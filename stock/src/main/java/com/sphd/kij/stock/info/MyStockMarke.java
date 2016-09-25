package com.sphd.kij.stock.info;

import java.util.List;

/**
 * Created by kij on 16/9/14.
 */
public class MyStockMarke {



    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBody   showapi_res_body;


    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBody getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBody {
        private int ret_code;
        private List<IndexList> indexList;
        private List<MyStocklist> list;
        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<IndexList> getIndexList() {
            return indexList;
        }

        public void setIndexList(List<IndexList> indexList) {
            this.indexList = indexList;
        }

        public List<MyStocklist> getList() {
            return list;
        }

        public void setList(List<MyStocklist> list) {
            this.list = list;
        }
    }
    public static class IndexList {
        private double yestodayClosePrice;
        private String time;
        private long tradeNum;
        private String name;
        private double tradeAmount;
        private double maxPrice;
        private String code;
        private double nowPrice;
        private double todayOpenPrice;
        private double minPrice;

        public double getYestodayClosePrice() {
            return yestodayClosePrice;
        }

        public void setYestodayClosePrice(double yestodayClosePrice) {
            this.yestodayClosePrice = yestodayClosePrice;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public long getTradeNum() {
            return tradeNum;
        }

        public void setTradeNum(long tradeNum) {
            this.tradeNum = tradeNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getTradeAmount() {
            return tradeAmount;
        }

        public void setTradeAmount(double tradeAmount) {
            this.tradeAmount = tradeAmount;
        }

        public double getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(double maxPrice) {
            this.maxPrice = maxPrice;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public double getNowPrice() {
            return nowPrice;
        }

        public void setNowPrice(double nowPrice) {
            this.nowPrice = nowPrice;
        }

        public double getTodayOpenPrice() {
            return todayOpenPrice;
        }

        public void setTodayOpenPrice(double todayOpenPrice) {
            this.todayOpenPrice = todayOpenPrice;
        }

        public double getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(double minPrice) {
            this.minPrice = minPrice;
        }
    }

    public static class MyStocklist{

        private String todayMax;
        private String competBuyPrice;
        private String buy5_n;
        private String buy2_n;
        private String tradeNum;
        private String buy2_m;
        private String buy5_m;
        private String sell3_m;
        private String openPrice;
        private String buy3_m;
        private String buy4_m;
        private String buy4_n;
        private String date;
        private String sell5_n;
        private String buy3_n;
        private String sell5_m;
        private String closePrice;
        private String time;
        private String sell3_n;
        private String name;
        private String sell4_n;
        private String sell4_m;
        private String tradeAmount;
        private String swing;
        private String diff_rate;
        private String sell1_n;
        private String todayMin;
        private String sell1_m;
        private String diff_money;
        private String code;
        private String sell2_m;
        private String nowPrice;
        private String sell2_n;
        private String buy1_m;
        private String buy1_n;
        private String market;
        private String competSellPrice;

        private String sellPrice;
        private String upRate;
        private String max52;
        private String upPrice;
        private String min52;
        private String ename;
        private String buyPrice;
        private String earn;

        public String getTodayMax() {
            return todayMax;
        }

        public void setTodayMax(String todayMax) {
            this.todayMax = todayMax;
        }

        public String getCompetBuyPrice() {
            return competBuyPrice;
        }

        public void setCompetBuyPrice(String competBuyPrice) {
            this.competBuyPrice = competBuyPrice;
        }

        public String getBuy5_n() {
            return buy5_n;
        }

        public void setBuy5_n(String buy5_n) {
            this.buy5_n = buy5_n;
        }

        public String getBuy2_n() {
            return buy2_n;
        }

        public void setBuy2_n(String buy2_n) {
            this.buy2_n = buy2_n;
        }

        public String getTradeNum() {
            return tradeNum;
        }

        public void setTradeNum(String tradeNum) {
            this.tradeNum = tradeNum;
        }

        public String getBuy2_m() {
            return buy2_m;
        }

        public void setBuy2_m(String buy2_m) {
            this.buy2_m = buy2_m;
        }

        public String getBuy5_m() {
            return buy5_m;
        }

        public void setBuy5_m(String buy5_m) {
            this.buy5_m = buy5_m;
        }

        public String getSell3_m() {
            return sell3_m;
        }

        public void setSell3_m(String sell3_m) {
            this.sell3_m = sell3_m;
        }

        public String getOpenPrice() {
            return openPrice;
        }

        public void setOpenPrice(String openPrice) {
            this.openPrice = openPrice;
        }

        public String getBuy3_m() {
            return buy3_m;
        }

        public void setBuy3_m(String buy3_m) {
            this.buy3_m = buy3_m;
        }

        public String getBuy4_m() {
            return buy4_m;
        }

        public void setBuy4_m(String buy4_m) {
            this.buy4_m = buy4_m;
        }

        public String getBuy4_n() {
            return buy4_n;
        }

        public void setBuy4_n(String buy4_n) {
            this.buy4_n = buy4_n;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSell5_n() {
            return sell5_n;
        }

        public void setSell5_n(String sell5_n) {
            this.sell5_n = sell5_n;
        }

        public String getBuy3_n() {
            return buy3_n;
        }

        public void setBuy3_n(String buy3_n) {
            this.buy3_n = buy3_n;
        }

        public String getSell5_m() {
            return sell5_m;
        }

        public void setSell5_m(String sell5_m) {
            this.sell5_m = sell5_m;
        }

        public String getClosePrice() {
            return closePrice;
        }

        public void setClosePrice(String closePrice) {
            this.closePrice = closePrice;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSell3_n() {
            return sell3_n;
        }

        public void setSell3_n(String sell3_n) {
            this.sell3_n = sell3_n;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSell4_n() {
            return sell4_n;
        }

        public void setSell4_n(String sell4_n) {
            this.sell4_n = sell4_n;
        }

        public String getSell4_m() {
            return sell4_m;
        }

        public void setSell4_m(String sell4_m) {
            this.sell4_m = sell4_m;
        }

        public String getTradeAmount() {
            return tradeAmount;
        }

        public void setTradeAmount(String tradeAmount) {
            this.tradeAmount = tradeAmount;
        }

        public String getSwing() {
            return swing;
        }

        public void setSwing(String swing) {
            this.swing = swing;
        }

        public String getDiff_rate() {
            return diff_rate;
        }

        public void setDiff_rate(String diff_rate) {
            this.diff_rate = diff_rate;
        }

        public String getSell1_n() {
            return sell1_n;
        }

        public void setSell1_n(String sell1_n) {
            this.sell1_n = sell1_n;
        }

        public String getTodayMin() {
            return todayMin;
        }

        public void setTodayMin(String todayMin) {
            this.todayMin = todayMin;
        }

        public String getSell1_m() {
            return sell1_m;
        }

        public void setSell1_m(String sell1_m) {
            this.sell1_m = sell1_m;
        }

        public String getDiff_money() {
            return diff_money;
        }

        public void setDiff_money(String diff_money) {
            this.diff_money = diff_money;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getSell2_m() {
            return sell2_m;
        }

        public void setSell2_m(String sell2_m) {
            this.sell2_m = sell2_m;
        }

        public String getNowPrice() {
            return nowPrice;
        }

        public void setNowPrice(String nowPrice) {
            this.nowPrice = nowPrice;
        }

        public String getSell2_n() {
            return sell2_n;
        }

        public void setSell2_n(String sell2_n) {
            this.sell2_n = sell2_n;
        }

        public String getBuy1_m() {
            return buy1_m;
        }

        public void setBuy1_m(String buy1_m) {
            this.buy1_m = buy1_m;
        }

        public String getBuy1_n() {
            return buy1_n;
        }

        public void setBuy1_n(String buy1_n) {
            this.buy1_n = buy1_n;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public String getCompetSellPrice() {
            return competSellPrice;
        }

        public void setCompetSellPrice(String competSellPrice) {
            this.competSellPrice = competSellPrice;
        }

        public String getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(String sellPrice) {
            this.sellPrice = sellPrice;
        }

        public String getUpRate() {
            return upRate;
        }

        public void setUpRate(String upRate) {
            this.upRate = upRate;
        }

        public String getMax52() {
            return max52;
        }

        public void setMax52(String max52) {
            this.max52 = max52;
        }

        public String getUpPrice() {
            return upPrice;
        }

        public void setUpPrice(String upPrice) {
            this.upPrice = upPrice;
        }

        public String getMin52() {
            return min52;
        }

        public void setMin52(String min52) {
            this.min52 = min52;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(String buyPrice) {
            this.buyPrice = buyPrice;
        }

        public String getEarn() {
            return earn;
        }

        public void setEarn(String earn) {
            this.earn = earn;
        }
    }

}
