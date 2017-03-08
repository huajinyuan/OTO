package cn.gtgs.base.OTO.activity.ShopCar.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.ShopCar.model.ShopCarGoods;
import cn.gtgs.base.OTO.activity.ShopCar.presenter.IChooseChanged;
import cn.gtgs.base.OTO.widget.AmountView;


/**
 * Created by gtgs on 2017/2/15.
 */

public class ShoppingCarAdatper extends RecyclerView.Adapter<ShoppingCarAdatper.ViewHolder> {

    private ArrayList<ShopCarGoods> mGoods;
    private IChooseChanged mChange;

    public ShoppingCarAdatper(ArrayList<ShopCarGoods> goods, IChooseChanged change) {
        this.mGoods = goods;
        this.mChange = change;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_shopping_car_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ShopCarGoods goods = mGoods.get(position);
        holder.mChecked.setChecked(goods.isChoose());
        holder.mTvPrice.setText("$ " + goods.getPrice());
        holder.mMountCount.setGoodsAmount(goods.getQty());
        holder.mMountCount.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                mGoods.get(position).setQty(amount);
                if (null != mChange) {
                    mChange.change(mGoods);
                }
            }
        });
        holder.mChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mGoods.get(position).setChoose(isChecked);
                if (null != mChange) {
                    mChange.change(mGoods);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGoods.size();
    }

    public int getAllPrice() {
        int allPrice = 0;
        for (ShopCarGoods goods : mGoods) {
            if (goods.isChoose()) {
                allPrice += goods.getPrice() * goods.getQty();
            }
        }
        return allPrice;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox mChecked;
        ImageView mImgIcon;
        TextView mTvGoodsName;
        TextView mTvPrice;
        AmountView mMountCount;

        public ViewHolder(View v) {
            super(v);
            mChecked = (CheckBox) v.findViewById(R.id.che_layout_item_shopping_car_choose);
            mImgIcon = (ImageView) v.findViewById(R.id.img_layout_item_shopping_car_icon);
            mTvGoodsName = (TextView) v.findViewById(R.id.tv_layout_item_shopping_car_name);
            mTvPrice = (TextView) v.findViewById(R.id.tv_layout_item_shopping_car_price);
            mMountCount = (AmountView) v.findViewById(R.id.amount_layout_item_shopping_car_count);
        }
    }
}
