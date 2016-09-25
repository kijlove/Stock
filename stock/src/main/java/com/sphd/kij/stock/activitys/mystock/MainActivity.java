package com.sphd.kij.stock.activitys.mystock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sphd.kij.stock.R;
import com.sphd.kij.stock.activitys.allstock.AllStockActivity;
import com.sphd.kij.stock.activitys.base.BaseActivity;
import com.sphd.kij.stock.activitys.stockinfo.StockInfoActivity;
import com.sphd.kij.stock.adapters.MyStockAdapter;
import com.sphd.kij.stock.base.StockApplication;
import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.StockInfo;
import com.sphd.kij.stock.key.StockKey;
import com.sphd.kij.stock.listener.OnItemClickListener;
import com.sphd.kij.stock.mvp.presenter.impl.MainPresenterImpl;
import com.sphd.kij.stock.mvp.view.MainView;

import org.litepal.crud.DataSupport;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import me.wangyuwei.flipshare.FlipShareView;
import me.wangyuwei.flipshare.ShareItem;

public class MainActivity extends BaseActivity implements MainView, OnItemClickListener {

    @Inject
    MyStockAdapter myStockAdapter;
    @Inject
    MainPresenterImpl mainPresenter;
    @Inject
    Activity mActivity;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.my_stock_recyclerview)
    RecyclerView myStockRV;
    @BindView(R.id.indexList_name01)
    TextView indexListName01;
    @BindView(R.id.indexList_price01)
    TextView indexListPrice01;
    @BindView(R.id.indexList_name02)
    TextView indexListName02;
    @BindView(R.id.indexList_price02)
    TextView indexListPrice02;
    @BindView(R.id.indexList_name03)
    TextView indexListName03;
    @BindView(R.id.indexList_price03)
    TextView indexListPrice03;
    @BindView(R.id.indexList_name04)
    TextView indexListName04;
    @BindView(R.id.indexList_price04)
    TextView indexListPrice04;
    @BindView(R.id.indexList_linear_01)
    LinearLayout indexListLinear01;
    @BindView(R.id.indexList_linear_02)
    LinearLayout indexListLinear02;
    @BindView(R.id.indexList_linear_03)
    LinearLayout indexListLinear03;
    @BindView(R.id.indexList_linear_04)
    LinearLayout indexListLinear04;
    private boolean mIsAllLoaded;
    private MyStockMarke stockMarke;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initViews() {
        mPresenter = mainPresenter;
        mPresenter.attachView(this);
        initRecyclerView();
        Timer timer = new Timer("RefreshStocks");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mainPresenter.refreshData();
            }
        }, 0, 100000); // 10 seconds

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String message) {
        Snackbar.make(fab, message, Snackbar.LENGTH_SHORT).setAction("新增",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(StockApplication.getContext(), AllStockActivity.class);
                        intent.putExtra(StockKey.STOCK_FLAG, "sh");

                        startActivity(intent);
                    }
                }).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mainPresenter.refreshData();
    }

    @Override
    public void initShowStockList(MyStockMarke myStockMarkeList) {
        stockMarke = myStockMarkeList;
        myStockAdapter.setList(myStockMarkeList.getShowapi_res_body().getList());
        myStockAdapter.notifyDataSetChanged();
        indexListPrice01.setTextColor(myStockMarkeList.getShowapi_res_body().getIndexList().get(0).getNowPrice() >
                myStockMarkeList.getShowapi_res_body().getIndexList().get(0).getYestodayClosePrice() ?
                Color.RED : Color.GREEN);
        indexListPrice02.setTextColor(myStockMarkeList.getShowapi_res_body().getIndexList().get(1).getNowPrice() >
                myStockMarkeList.getShowapi_res_body().getIndexList().get(1).getYestodayClosePrice() ?
                Color.RED : Color.GREEN);
        indexListPrice03.setTextColor(myStockMarkeList.getShowapi_res_body().getIndexList().get(2).getNowPrice() >
                myStockMarkeList.getShowapi_res_body().getIndexList().get(2).getYestodayClosePrice() ?
                Color.RED : Color.GREEN);
        indexListPrice04.setTextColor(myStockMarkeList.getShowapi_res_body().getIndexList().get(3).getNowPrice()>
                myStockMarkeList.getShowapi_res_body().getIndexList().get(3).getYestodayClosePrice()?
                Color.RED : Color.GREEN);
        indexListName01.setText(myStockMarkeList.getShowapi_res_body().getIndexList().get(0).getName());
        indexListName02.setText(myStockMarkeList.getShowapi_res_body().getIndexList().get(1).getName());
        indexListName03.setText(myStockMarkeList.getShowapi_res_body().getIndexList().get(2).getName());
        indexListName04.setText(myStockMarkeList.getShowapi_res_body().getIndexList().get(3).getName());
        indexListPrice01.setText(myStockMarkeList.getShowapi_res_body().getIndexList().get(0).getNowPrice() + "");
        indexListPrice02.setText(myStockMarkeList.getShowapi_res_body().getIndexList().get(1).getNowPrice() + "");
        indexListPrice03.setText(myStockMarkeList.getShowapi_res_body().getIndexList().get(2).getNowPrice() + "");
        indexListPrice04.setText(myStockMarkeList.getShowapi_res_body().getIndexList().get(3).getNowPrice() + "");
    }

    @OnClick(R.id.indexList_linear_01)
    public void indexListLinear_01() {
        showIndexList(stockMarke, 0, indexListLinear01);
    }

    @OnClick(R.id.indexList_linear_02)
    public void indexListLinear_02() {
        showIndexList(stockMarke, 1, indexListLinear02);
    }

    @OnClick(R.id.indexList_linear_03)
    public void indexListLinear_03() {
        showIndexList(stockMarke, 2, indexListLinear03);
    }

    @OnClick(R.id.indexList_linear_04)
    public void indexListLinear_04() {
        showIndexList(stockMarke, 3, indexListLinear04);
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
                        break;
                    case 1:
                        flag = "sz";
                        break;
                    case 2:
                        flag = "sh";
                        break;
                    default:
                        break;
                }
                Intent intent = new Intent();
                intent.setClass(StockApplication.getContext(), AllStockActivity.class);
                intent.putExtra(StockKey.STOCK_FLAG, flag);
                startActivity(intent);
            }

            @Override
            public void dismiss() {

            }
        });
    }

    /*初始化recyclerview*/
    private void initRecyclerView() {
        myStockRV.setHasFixedSize(true);
        myStockRV.setLayoutManager(new LinearLayoutManager(mActivity,
                LinearLayoutManager.VERTICAL, false));
        myStockRV.setItemAnimator(new DefaultItemAnimator());
        myStockAdapter.setOnItemClickListener(this);
        myStockRV.setAdapter(myStockAdapter);
    }

    private void showIndexList(MyStockMarke stockMarke, int positon, View view) {
        FlipShareView showIndexList = new FlipShareView.Builder(this, view)
                .addItem(new ShareItem("昨日收盘价:\n" +
                        stockMarke.getShowapi_res_body().getIndexList().get(positon).getYestodayClosePrice(),
                        Color.WHITE, 0xff43549C))
                .addItem(new ShareItem("成交量:\n" +
                        stockMarke.getShowapi_res_body().getIndexList().get(positon).getTradeNum(),
                        Color.WHITE, 0xff4999F0))
                .addItem(new ShareItem("成交金额:\n" +
                        stockMarke.getShowapi_res_body().getIndexList().get(positon).getTradeAmount(),
                        Color.WHITE, 0xffD9392D))
                .setBackgroundColor(0x60000000)
                .setDefaultWidth(240)
                .create();
    }

    @Override
    public void onItemClick(View view, int position) {
        if (view.getId() == R.id.stock_card) {
            List<StockInfo> stockInfoList = DataSupport.where("name = ?",
                    stockMarke.getShowapi_res_body().getList().get(position).getName()).
                    find(StockInfo.class);
            if (stockInfoList.size() > 0) {

                Intent intent = new Intent();
                intent.setClass(StockApplication.getContext(), StockInfoActivity.class);
                intent.putExtra(StockKey.STOCK_CODE,
                        stockInfoList.get(0).getSymbol().startsWith("s") ?
                                stockInfoList.get(0).getSymbol().substring(2,
                                        stockInfoList.get(0).getSymbol().length()) :
                                stockInfoList.get(0).getSymbol());
                startActivity(intent);

            }
        }
    }
}
