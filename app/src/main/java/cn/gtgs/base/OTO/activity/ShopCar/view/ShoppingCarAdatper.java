package cn.gtgs.base.OTO.activity.ShopCar.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.gtgs.base.OTO.R;


/**
 * Created by gtgs on 2017/2/15.
 */

public class ShoppingCarAdatper extends RecyclerView.Adapter<ShoppingCarAdatper.ViewHolder> {

//    private List<String> images;

    public ShoppingCarAdatper() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_shopping_car_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
