package com.sphd.kij.stock.repository.network;

import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.StockInfoInternet;
import com.sphd.kij.stock.info.Stocklist;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kij on 16/9/14.
 */
public interface StockService {
    @FormUrlEncoded
    @POST("131-46?")
    Call<MyStockMarke> getMyStock(@FieldMap Map<String, String> map);//添加帐户信息
    @FormUrlEncoded
    @POST("finance/stock/szall?")
    Call<Stocklist> getszALLStock(@FieldMap Map<String, String> map);//全部的深圳股票数据
    @FormUrlEncoded
    @POST("finance/stock/hkall?")
    Call<Stocklist> gethkALLStock(@FieldMap Map<String, String> map);//全部的香港股票数据
    @FormUrlEncoded
    @POST("finance/stock/shall?")
    Call<Stocklist> getshALLStock(@FieldMap Map<String, String> map);//全部的上海股票数据
    @FormUrlEncoded
    @POST("131-44?")
    Call<StockInfoInternet> getStockInfoInternet(@FieldMap Map<String, String> map);//获取单条股票信息

}
