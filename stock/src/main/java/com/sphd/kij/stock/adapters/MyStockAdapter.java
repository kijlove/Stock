package com.sphd.kij.stock.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sphd.kij.stock.R;
import com.sphd.kij.stock.adapters.base.BaseRecyclerViewAdapter;
import com.sphd.kij.stock.info.MyStockMarke;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的自选的股票行情
 * Created by kij on 16/9/18.
 */
public class MyStockAdapter extends BaseRecyclerViewAdapter<MyStockMarke.MyStocklist> {

    @Inject
    public MyStockAdapter() {
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
                view = getView(parent, R.layout.item_mystocklist_adapter);//我的自选的数据显示
                final ItemViewHolder itemViewHolder = new ItemViewHolder(view);
                setItemOnClickEvent(itemViewHolder);
                return itemViewHolder;
            default:
                throw new RuntimeException("there is no type that matches the type " +
                        viewType + " + make sure your using types correctly");
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

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
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

    //设置我的自选股票列表
    private void setItemValues(ItemViewHolder holder, int position) {
        MyStockMarke.MyStocklist myStocklist = mList.get(position);
        String title = myStocklist.getName();//股票名称
        if (title == null) {
            title = myStocklist.getName();
        }


        holder.stockName.setText(myStocklist.getName());
        holder.stockDate.setText(myStocklist.getDate());
        holder.stockTime.setText(myStocklist.getTime());
        holder.nowPrice.setText(myStocklist.getNowPrice());
        holder.todayMax.setText(myStocklist.getTodayMax());
        holder.todayMin.setText(myStocklist.getTodayMin());
        holder.diffMoney.setText(myStocklist.getDiff_money());
        holder.diffRate.setText(myStocklist.getDiff_rate());
        holder.swing.setText(myStocklist.getSwing());
        holder.openPrice.setText(myStocklist.getOpenPrice());
        holder.closePrice.setText(myStocklist.getClosePrice());
        holder.competBuyPrice.setText(myStocklist.getCompetBuyPrice());
        holder.competSellPrice.setText(myStocklist.getCompetSellPrice());
        holder.tradeNum.setText(myStocklist.getTradeNum());
        holder.tradeAmount.setText(myStocklist.getTradeAmount());
        holder.buy1N.setText(myStocklist.getBuy1_n());
        holder.buy1M.setText(myStocklist.getBuy1_m());
        holder.buy2N.setText(myStocklist.getBuy2_n());
        holder.buy2M.setText(myStocklist.getBuy2_m());
        holder.buy3N.setText(myStocklist.getBuy3_n());
        holder.buy3M.setText(myStocklist.getBuy3_m());
        holder.buy4N.setText(myStocklist.getBuy4_n());
        holder.buy4M.setText(myStocklist.getBuy4_m());
        holder.buy5N.setText(myStocklist.getBuy5_n());
        holder.buy5M.setText(myStocklist.getBuy5_m());
        holder.sell1N.setText(myStocklist.getSell1_n());
        holder.sell1M.setText(myStocklist.getSell1_m());
        holder.sell2N.setText(myStocklist.getSell2_n());
        holder.sell2M.setText(myStocklist.getSell2_m());
        holder.sell3N.setText(myStocklist.getSell3_n());
        holder.sell3M.setText(myStocklist.getSell3_m());
        holder.sell4N.setText(myStocklist.getSell4_n());
        holder.sell4M.setText(myStocklist.getSell4_m());
        holder.sell5N.setText(myStocklist.getSell5_n());
        holder.sell5M.setText(myStocklist.getSell5_m());
        holder.diffRate.setTextColor(myStocklist.getDiff_rate().startsWith("-") ?
                Color.GREEN : Color.RED);
        holder.diffMoney.setTextColor(myStocklist.getDiff_money().startsWith("-") ?
                Color.GREEN : Color.RED);
    }


    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (isShowingAnimation(holder)) {
            holder.itemView.clearAnimation();
        }
    }

    private boolean isShowingAnimation(RecyclerView.ViewHolder holder) {
        return holder.itemView.getAnimation() != null && holder.itemView
                .getAnimation().hasStarted();
    }

    /*我的自选股票*/
    class ItemViewHolder extends RecyclerView.ViewHolder {


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

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}