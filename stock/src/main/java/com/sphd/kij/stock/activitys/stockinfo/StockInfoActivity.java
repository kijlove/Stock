package com.sphd.kij.stock.activitys.stockinfo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sphd.kij.stock.R;
import com.sphd.kij.stock.activitys.base.BaseActivity;
import com.sphd.kij.stock.base.StockApplication;
import com.sphd.kij.stock.info.StockInfo;
import com.sphd.kij.stock.info.StockInfoInternet;
import com.sphd.kij.stock.key.StockKey;
import com.sphd.kij.stock.mvp.presenter.impl.StockInfoPresenterImpl;
import com.sphd.kij.stock.mvp.view.StockInfoView;
import com.squareup.picasso.Picasso;

import org.litepal.crud.DataSupport;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/*单个股票的数据*/
public class StockInfoActivity extends BaseActivity implements StockInfoView {
    @Inject
    StockInfoPresenterImpl stockInfoPresenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.stock_card)
    CardView stockCard;
    @BindView(R.id.stock_name)
    TextView stockName;
    @BindView(R.id.stock_date)
    TextView stockDate;
    @BindView(R.id.stock_time)
    TextView stockTime;
    @BindView(R.id.nowPrice)
    TextView nowPrice;
    @BindView(R.id.todayMax)
    TextView todayMax;
    @BindView(R.id.todayMin)
    TextView todayMin;
    @BindView(R.id.diff_money)
    TextView diffMoney;
    @BindView(R.id.diff_rate)
    TextView diffRate;
    @BindView(R.id.swing)
    TextView swing;
    @BindView(R.id.openPrice)
    TextView openPrice;
    @BindView(R.id.closePrice)
    TextView closePrice;
    @BindView(R.id.competBuyPrice)
    TextView competBuyPrice;
    @BindView(R.id.competSellPrice)
    TextView competSellPrice;
    @BindView(R.id.tradeNum)
    TextView tradeNum;
    @BindView(R.id.tradeAmount)
    TextView tradeAmount;
    @BindView(R.id.buy1_n)
    TextView buy1N;
    @BindView(R.id.buy1_m)
    TextView buy1M;
    @BindView(R.id.buy2_n)
    TextView buy2N;
    @BindView(R.id.buy2_m)
    TextView buy2M;
    @BindView(R.id.buy3_n)
    TextView buy3N;
    @BindView(R.id.buy3_m)
    TextView buy3M;
    @BindView(R.id.buy4_n)
    TextView buy4N;
    @BindView(R.id.buy4_m)
    TextView buy4M;
    @BindView(R.id.buy5_n)
    TextView buy5N;
    @BindView(R.id.buy5_m)
    TextView buy5M;
    @BindView(R.id.sell1_n)
    TextView sell1N;
    @BindView(R.id.sell1_m)
    TextView sell1M;
    @BindView(R.id.sell2_n)
    TextView sell2N;
    @BindView(R.id.sell2_m)
    TextView sell2M;
    @BindView(R.id.sell3_n)
    TextView sell3N;
    @BindView(R.id.sell3_m)
    TextView sell3M;
    @BindView(R.id.sell4_n)
    TextView sell4N;
    @BindView(R.id.sell4_m)
    TextView sell4M;
    @BindView(R.id.sell5_n)
    TextView sell5N;
    @BindView(R.id.sell5_m)
    TextView sell5M;
    @BindView(R.id.monthurl_img)
    ImageView monthurlImg;
    @BindView(R.id.minurl_img)
    ImageView minurlImg;
    @BindView(R.id.weekurl_img)
    ImageView weekurlImg;
    @BindView(R.id.dayurl_img)
    ImageView dayurlImg;
    @BindView(R.id.sell_buy_five)
    LinearLayout sellBuyFive;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private String code;
    private StockInfoInternet stockInfoInternet;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stock_info;
    }

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initViews() {
        initToolbar(toolbar);
        sellBuyFive.setVisibility(View.VISIBLE);
        code = getIntent().getStringExtra(StockKey.STOCK_CODE);
        stockInfoPresenter.setCode(code);
        mPresenter = stockInfoPresenter;
        mPresenter.attachView(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*用于显示接受完毕后的股票数据*/
    @Override
    public void initShowStockInfo(StockInfoInternet stockInfoInternet) {
        this.stockInfoInternet = stockInfoInternet;
        if (stockInfoInternet.getShowapi_res_body().getRet_code() == 0) {
            toolbar.setSubtitle("编号:" + stockInfoInternet.getShowapi_res_body().getStockMarket().getCode());
            stockName.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getName());
            stockDate.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getDate());
            stockTime.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getTime());
            nowPrice.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getNowPrice());
            todayMax.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getTodayMax());
            todayMin.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getTodayMin());
            diffMoney.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getDiff_money());
            diffRate.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getDiff_rate());
            swing.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSwing());
            openPrice.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getOpenPrice());
            closePrice.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getClosePrice());
            competBuyPrice.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getCompetBuyPrice());
            competSellPrice.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getCompetSellPrice());
            tradeNum.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getTradeNum());
            tradeAmount.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getTradeAmount());
            buy1N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy1_n());
            buy1M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy1_m());
            buy2N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy2_n());
            buy2M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy2_m());
            buy3N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy3_n());
            buy3M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy3_m());
            buy4N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy4_n());
            buy4M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy4_m());
            buy5N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy5_n());
            buy5M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getBuy5_m());
            sell1N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell1_n());
            sell1M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell1_m());
            sell2N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell2_n());
            sell2M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell2_m());
            sell3N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell3_n());
            sell3M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell3_m());
            sell4N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell4_n());
            sell4M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell4_m());
            sell5N.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell5_n());
            sell5M.setText(stockInfoInternet.getShowapi_res_body().getStockMarket().getSell5_m());

            Picasso.with(StockApplication.getAppContext()).load(
                    stockInfoInternet.getShowapi_res_body().getK_pic().getMonthurl())
                    .placeholder(R.color.image_place_holder)
                    .error(R.mipmap.ic_launcher)
                    .into(monthurlImg);
            Picasso.with(StockApplication.getAppContext()).load(
                    stockInfoInternet.getShowapi_res_body().getK_pic().getMinurl())
                    .placeholder(R.color.image_place_holder)
                    .error(R.mipmap.ic_launcher)
                    .into(minurlImg);
            Picasso.with(StockApplication.getAppContext()).load(
                    stockInfoInternet.getShowapi_res_body().getK_pic().getWeekurl())
                    .placeholder(R.color.image_place_holder)
                    .error(R.mipmap.ic_launcher)
                    .into((weekurlImg));
            Picasso.with(StockApplication.getAppContext()).load(
                    stockInfoInternet.getShowapi_res_body().getK_pic().getDayurl())
                    .placeholder(R.color.image_place_holder)
                    .error(R.mipmap.ic_launcher)
                    .into(dayurlImg);
            if (stockInfoInternet.getShowapi_res_body().
                    getStockMarket().getMarket().equals("hk")) {
                sellBuyFive.setVisibility(View.GONE);
            }
        } else {
            Snackbar.make(fab, "找不到此股票", Snackbar.LENGTH_SHORT).setAction("返回",
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    }

            ).show();
        }

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

    @OnClick(R.id.fab)
    public void setDeleStockCode() {
        Snackbar.make(fab, "真的要在自选中删除该股票吗?", Snackbar.LENGTH_SHORT).setAction("确定",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleStockFromZxData(stockInfoInternet.getShowapi_res_body().
                                getStockMarket().getMarket());
                    }
                }

        ).show();
    }

    private void deleStockFromZxData(String market) {
        String stockcode = market.endsWith("hk") ? code : market + code;
        int deleNum =
                DataSupport.deleteAll(StockInfo.class,
                        "symbol = ? ", stockcode);
        if (deleNum > 0) {
            Snackbar.make(fab, "已经在自选中删除", Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(fab, "该股票不在自选范围内", Snackbar.LENGTH_SHORT).show();
        }
    }
}
