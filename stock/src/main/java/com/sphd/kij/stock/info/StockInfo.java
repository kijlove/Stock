package com.sphd.kij.stock.info;

import org.litepal.crud.DataSupport;

/**
 * Created by kij on 16/9/13.
 */
public class StockInfo   extends DataSupport {
    private int id;
    private String symbol; /*代码*/
    private String name;/*名称*/
    private String engname;/*英文名*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
