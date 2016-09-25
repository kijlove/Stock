package com.sphd.kij.stock.info;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 全部的股票信息
 * Created by kij on 16/9/13.
 */
public class Stocklist {


    private int error_code;
    private String reason;


    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String totalCount;
        private String page;
        private String num;
        private List<Stock> data;

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<Stock> getData() {
            return data;
        }

        public void setData(List<Stock> data) {
            this.data = data;
        }

    }

    public static class Stock {
        private String symbol; /*代码*/
        private String name;/*名称*/
        private String engname;/*英文名*/
        private String tradetype;
        private String trade;//深沪价格
        private String lasttrade;/*最新价*/
        private String prevclose;/*昨收*/
        private String open;/*今开*/
        private String high;/*最高*/
        private String low;/*最低*/
        private String volume;/*成交量*/
        private String currentvolume;
        private String amount;/*成交额*/
        private String ticktime;/*时间*/
        private String buy;/*买入*/
        private String sell;/*卖出*/
        private String high_52week;/*52周最高*/
        private String low_52week;/*52周最低*/
        private String eps;
        private String dividend;
        private String stocks_sum;/*总股本*/
        private String pricechange;/*涨跌额*/
        private String changepercent;/*涨跌幅*/

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEngname() {
            return engname;
        }

        public void setEngname(String engname) {
            this.engname = engname;
        }

        public String getTradetype() {
            return tradetype;
        }

        public void setTradetype(String tradetype) {
            this.tradetype = tradetype;
        }

        public String getTrade() {
            return trade;
        }

        public void setTrade(String trade) {
            this.trade = trade;
        }

        public String getLasttrade() {
            return lasttrade;
        }

        public void setLasttrade(String lasttrade) {
            this.lasttrade = lasttrade;
        }

        public String getPrevclose() {
            return prevclose;
        }

        public void setPrevclose(String prevclose) {
            this.prevclose = prevclose;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getCurrentvolume() {
            return currentvolume;
        }

        public void setCurrentvolume(String currentvolume) {
            this.currentvolume = currentvolume;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getTicktime() {
            return ticktime;
        }

        public void setTicktime(String ticktime) {
            this.ticktime = ticktime;
        }

        public String getBuy() {
            return buy;
        }

        public void setBuy(String buy) {
            this.buy = buy;
        }

        public String getSell() {
            return sell;
        }

        public void setSell(String sell) {
            this.sell = sell;
        }

        public String getHigh_52week() {
            return high_52week;
        }

        public void setHigh_52week(String high_52week) {
            this.high_52week = high_52week;
        }

        public String getLow_52week() {
            return low_52week;
        }

        public void setLow_52week(String low_52week) {
            this.low_52week = low_52week;
        }

        public String getEps() {
            return eps;
        }

        public void setEps(String eps) {
            this.eps = eps;
        }

        public String getDividend() {
            return dividend;
        }

        public void setDividend(String dividend) {
            this.dividend = dividend;
        }

        public String getStocks_sum() {
            return stocks_sum;
        }

        public void setStocks_sum(String stocks_sum) {
            this.stocks_sum = stocks_sum;
        }

        public String getPricechange() {
            return pricechange;
        }

        public void setPricechange(String pricechange) {
            this.pricechange = pricechange;
        }

        public String getChangepercent() {
            return changepercent;
        }

        public void setChangepercent(String changepercent) {
            this.changepercent = changepercent;
        }
    }
}
