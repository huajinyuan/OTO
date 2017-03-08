package cn.gtgs.base.OTO.activity.home.view;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.buy.BuyNowInfoActivity;
import cn.gtgs.base.OTO.activity.home.model.ProductGoods;
import cn.gtgs.base.OTO.utils.IntentKey;
import cn.gtgs.base.OTO.widget.SweetAlert.Add2ShoppingCarAlertDialog;


/**
 * Created by gtgs on 2017/2/15.
 */

public class HomeAdatper extends RecyclerView.Adapter<HomeAdatper.ViewHolder> {

    private ArrayList<ProductGoods> mGoods;

    public HomeAdatper(ArrayList<ProductGoods> goods) {
        this.mGoods = goods;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_home_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ProductGoods goods = mGoods.get(position);
        holder.btnAdd2Car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new SweetAlertDialog(holder.btnAdd2Car.getContext(), SweetAlertDialog.SUCCESS_TYPE)
//                        .setTitleText("successful!")
//                        .setContentText("You clicked the button!")
//                        .show();
                new Add2ShoppingCarAlertDialog(holder.btnAdd2Car.getContext()).show();
            }
        });
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.btnBuy.getContext(), BuyNowInfoActivity.class);
                intent.putExtra(IntentKey.PRODUCTTOBUY,mGoods.get(position));
                holder.btnBuy.getContext().startActivity(intent);
            }
        });
        holder.tvName.setText(goods.getName());
        holder.tvPrice.setText("$ " + goods.getPrice());


    }

    @Override
    public int getItemCount() {
        return mGoods.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        CardView content;
        TextView tvName;
        TextView tvPrice;
        Button btnBuy;
        Button btnAdd2Car;

        public ViewHolder(View v) {
            super(v);
            this.icon = (ImageView) v.findViewById(R.id.img_layout_home_item_content_icon);
            this.content = (CardView) v.findViewById(R.id.cardview_layout_home_item_content_content);
            this.tvName = (TextView) v.findViewById(R.id.tv_layout_home_item_content_name);
            this.tvPrice = (TextView) v.findViewById(R.id.tv_layout_home_item_content_price);
            this.btnBuy = (Button) v.findViewById(R.id.btn_layout_home_item_content_buy);
            this.btnAdd2Car = (Button) v.findViewById(R.id.btn_layout_home_item_content_add2car);
        }
    }
}
