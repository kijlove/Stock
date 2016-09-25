package com.sphd.kij.stock.key;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kij on 16/9/14.
 */
public class StockKey {
    public static String myStockListurl="https://route.showapi.com/131-46?" ;//批量获取股票详情
    public static String showapi_appid="24531";
    public static String showapi_sign="f8f72c75e83e45aaac865750183e7007";
    public static String juhe_key="561048e99c92b918e92bd610b3b212bb";//聚合数据的key
    public static String getShowapi_timestamp() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String showapi_timestamp = formatter.format(curDate);
        return  showapi_timestamp;
    }

    public static String STOCK_CODE="code";//用于传递股票编码ID
    public static String STOCK_FLAG="stock_flag";//深沪港股的区分

}
