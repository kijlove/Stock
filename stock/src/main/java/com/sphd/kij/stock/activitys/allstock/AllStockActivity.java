package com.sphd.kij.stock.activitys.allstock;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.socks.library.KLog;
import com.sphd.kij.stock.R;
import com.sphd.kij.stock.activitys.base.BaseActivity;
import com.sphd.kij.stock.activitys.mystock.MainActivity;
import com.sphd.kij.stock.activitys.stockinfo.StockInfoActivity;
import com.sphd.kij.stock.adapters.AllStockListAdapter;
import com.sphd.kij.stock.base.StockApplication;
import com.sphd.kij.stock.info.StockInfo;
import com.sphd.kij.stock.info.Stocklist;
import com.sphd.kij.stock.key.StockKey;
import com.sphd.kij.stock.listener.OnItemClickListener;
import com.sphd.kij.stock.mvp.presenter.impl.AllStockPresenterImpl;
import com.sphd.kij.stock.mvp.view.AllStockView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import me.wangyuwei.flipshare.FlipShareView;
import me.wangyuwei.flipshare.ShareItem;

public class AllStockActivity extends BaseActivity implements AllStockView, OnItemClickListener {


    @Inject
    AllStockPresenterImpl allStockPresenter;
    @Inject
    AllStockListAdapter myStockAdapter;

    @Inject
    Activity mActivity;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.my_stock_recyclerview)
    RecyclerView myStockRV;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private boolean mIsAllLoaded;
    private List<Stocklist.Stock> stockList;
    private Context context;

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_stock;
    }

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initViews() {
        context =AllStockActivity.this;
        initToolbar(toolbar);
        stockList = new ArrayList<Stocklist.Stock>();
        allStockPresenter.setStockArea(getIntent().getStringExtra(StockKey.STOCK_FLAG));
        mPresenter = allStockPresenter;
        mPresenter.attachView(this);
        initRecyclerView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initShowStockList(Stocklist stocklist) {
        stockList.addAll(stocklist.getResult().getData());
        myStockAdapter.setList(stockList);
        myStockAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String message) {

    }

    private void initRecyclerView() {
        myStockRV.setHasFixedSize(true);
        myStockRV.setLayoutManager(new LinearLayoutManager(mActivity,
                LinearLayoutManager.VERTICAL, false));
        myStockRV.setItemAnimator(new DefaultItemAnimator());
        myStockRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

                int lastVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                        .findLastVisibleItemPosition();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();

                if (!mIsAllLoaded && visibleItemCount > 0 && newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItemPosition >= totalItemCount - 1) {
                    allStockPresenter.loadMore();
                    myStockAdapter.showFooter();
                    myStockRV.scrollToPosition(myStockAdapter.getItemCount() - 1);
                }
            }

        });

        myStockAdapter.setOnItemClickListener(this);
        myStockRV.setAdapter(myStockAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        List<StockInfo> stockInfoList = DataSupport.where("symbol = ?",
                stockList.get(position).getSymbol()).
                find(StockInfo.class);
        if (stockInfoList.size() > 0) {
            Snackbar.make(view, "自选列表已存在该股票", Snackbar.LENGTH_SHORT).show();
        } else {

            if (view.getId() == R.id.stock_card) {
                KLog.e(stockList.get(position).getName());
                StockInfo stockInfo = new StockInfo();
                stockInfo.setName(stockList.get(position).getName());
                stockInfo.setSymbol(stockList.get(position).getSymbol());
                stockInfo.setEngname(stockList.get(position).getEngname());
                stockInfo.save();
                if (stockInfo.isSaved()) {
                    Snackbar.make(view, "添加自选成功", Snackbar.LENGTH_SHORT).show();
                }
            }
        }
        Intent intent = new Intent();
        intent.setClass(StockApplication.getContext(), StockInfoActivity.class);
        intent.putExtra(StockKey.STOCK_CODE,
                stockList.get(position).getSymbol().startsWith("s") ?
                        stockList.get(position).getSymbol().substring(2,
                                stockList.get(position).getSymbol().length()) :
                        stockList.get(position).getSymbol());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //切换沪股数据
        if (id == R.id.action_stock_search) {

            showInputdialog();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.fab)
    public void addMyStock() {
        FlipShareView share6 = new FlipShareView.Builder(this, fab)
                .addItem(new ShareItem("沪股列表", Color.WHITE, 0xff43549C))
                .addItem(new ShareItem("深股列表", Color.WHITE, 0xff4999F0))
                .addItem(new ShareItem("港股列表", Color.WHITE, 0xffD9392D))
                .setBackgroundColor(0x60000000)
                .create();
        share6.setOnFlipClickListener(new FlipShareView.OnFlipClickListener() {
            @Override
            public void onItemClick(int position) {
                String flag = "sh";
                switch (position) {
                    case 0:
                        flag = "hk";
                        allStockPresenter.setStockArea("hk");
                        stockList.clear();
                        mPresenter.onCreate();
                        break;
                    case 1:
                        flag = "sz";
                        allStockPresenter.setStockArea("sz");
                        stockList.clear();
                        mPresenter.onCreate();
                        break;
                    case 2:
                        flag = "sh";
                        allStockPresenter.setStockArea("sh");
                        stockList.clear();
                        mPresenter.onCreate();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void dismiss() {

            }
        });
    }

    /**
     * 输入股票编号查询
     */
    private void showInputdialog() {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.search_input, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final TextInputEditText inputedittext = (TextInputEditText) promptsView
                .findViewById(R.id.input_edit);

        alertDialogBuilder.setTitle(" 输入股票编号");

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent();
                                intent.setClass(StockApplication.getContext(), StockInfoActivity.class);
                                intent.putExtra(StockKey.STOCK_CODE,inputedittext.getText().toString());
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

}
