package com.sphd.kij.stock.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sphd.kij.stock.R;
import com.sphd.kij.stock.adapters.base.BaseRecyclerViewAdapter;
import com.sphd.kij.stock.info.Stocklist;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kij on 16/9/19.
 */
public class AllStockListAdapter extends BaseRecyclerViewAdapter<Stocklist.Stock> {


    @Inject
    public AllStockListAdapter() {
        super(null);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view;
        switch (viewType) {
            case TYPE_FOOTER:
                view = getView(parent, R.layout.item_mystock_footer);//加载更多
                return new FooterViewHolder(view);
            case TYPE_ITEM:
                view = getView(parent, R.layout.item_all_stock_adapter);//我的自选的数据显示
                final ItemViewHolder itemViewHolder = new ItemViewHolder(view);
                setItemOnClickEvent(itemViewHolder);
                return itemViewHolder;
            default:
                throw new RuntimeException("there is no type that matches the type " +
                        viewType + " + make sure your using types correctly");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mIsShowFooter && isFooterPosition(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        setValues(holder, position);
        setItemAppearAnimation(holder, position, R.anim.anim_bottom_in);
    }

    private void setValues(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            setItemValues((ItemViewHolder) holder, position);
        }
    }

    private void setItemOnClickEvent(final RecyclerView.ViewHolder holder) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    (mOnItemClickListener).
                            onItemClick(v, holder.getLayoutPosition());
                }
            });
        }
    }

    //设置我的自选股票列表
    private void setItemValues(ItemViewHolder holder, int position) {
        Stocklist.Stock mystock = mList.get(position);
        String title = mystock.getName();//股票名称
        if (title == null) {
            title = mystock.getName();
        }


        holder.stockName.setText(mystock.getName());
        holder.stockSymbol.setText(mystock.getSymbol().startsWith("s") ?
                mystock.getSymbol().substring(2, mystock.getSymbol().length()) : mystock.getSymbol());
        holder.stockLasttrade.setText(mystock.getSymbol().startsWith("s") ?
                mystock.getTrade() : mystock.getLasttrade());
        holder.stockChangepercent.setText(mystock.getChangepercent().substring(0,5));
        holder.stockChangepercent.setTextColor(mystock.getChangepercent().startsWith("-") ?
                Color.GREEN : Color.RED);
        holder.stockLasttrade.setTextColor(mystock.getChangepercent().startsWith("-") ?
                Color.GREEN : Color.RED);

    }


    /*我的自选股票*/
    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stock_name)
        TextView stockName;

        @BindView(R.id.stock_symbol)
        TextView stockSymbol;

        @BindView(R.id.stock_lasttrade)
        TextView stockLasttrade;
        @BindView(R.id.stock_changepercent)
        TextView stockChangepercent;

        @BindView(R.id.stock_card)
        CardView stockCard;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
