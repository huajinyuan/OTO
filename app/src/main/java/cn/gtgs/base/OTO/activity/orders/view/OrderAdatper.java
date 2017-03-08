package cn.gtgs.base.OTO.activity.orders.view;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.orders.model.NewOrderData;


/**
 * Created by gtgs on 2017/2/15.
 */

public class OrderAdatper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<NewOrderData> mDatas;
    private final int HEAD = 0;
    private final int FOOT = 1;
    private final int FIRSTITEM = 2;
    private final int NORMALITEM = 3;
    private Context context;

    public OrderAdatper(ArrayList<NewOrderData> datas, Context context) {
        this.mDatas = datas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_order_item_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        View top = viewHolder.getView(R.id.layout_item_top);
        View center = viewHolder.getView(R.id.layout_item_center);
        View bottom = viewHolder.getView(R.id.layout_item_bottom);

        int type = getContentType(position);
        switch (type) {
            case HEAD:
                top.setVisibility(View.VISIBLE);
                center.setVisibility(View.GONE);
                bottom.setVisibility(View.GONE);
                break;
            case FOOT:
                top.setVisibility(View.GONE);
                center.setVisibility(View.GONE);
                bottom.setVisibility(View.VISIBLE);
                ((TextView) viewHolder.getView(R.id.tv_layout_order_item_foot_detail)).getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                break;
            case FIRSTITEM:
                top.setVisibility(View.GONE);
                center.setVisibility(View.VISIBLE);
                bottom.setVisibility(View.GONE);
                break;
            case NORMALITEM:
                top.setVisibility(View.GONE);
                center.setVisibility(View.VISIBLE);
                bottom.setVisibility(View.GONE);
                break;
        }
        if (type == HEAD) {
            ((TextView) viewHolder.getView(R.id.tv_item_order_head_time)).setText(mDatas.get(position).getDate());
        } else if (type == FIRSTITEM) {
            viewHolder.getView(R.id.view_order_item_line).setVisibility(View.GONE);
            TextView tvStatus = viewHolder.getView(R.id.tv_order_item_status);
            tvStatus.setVisibility(View.VISIBLE);
            tvStatus.setText(mDatas.get(position).getStatus());

//            ((TextView) viewHolder.getView(R.id.item_Tv)).setText(mDatas.get(position).getOrder());
//            ((TextView) viewHolder.getView(R.id.item_pTv)).setText("￥" + mDatas.get(position).getPrice());
//            Picasso.with(context).load(mDatas.get(position).getImage()).into(((ImageView) viewHolder.getView(R.id.item_Iv)));
        } else if (type == NORMALITEM) {
            viewHolder.getView(R.id.view_order_item_line).setVisibility(View.VISIBLE);
            TextView tvStatus = viewHolder.getView(R.id.tv_order_item_status);
            tvStatus.setVisibility(View.INVISIBLE);
//            ((TextView) viewHolder.getView(R.id.item_Tv)).setText(mDatas.get(position).getOrder());
//            ((TextView) viewHolder.getView(R.id.item_pTv)).setText("￥" + mDatas.get(position).getPrice());
//            Picasso.with(context).load(mDatas.get(position).getImage()).into(((ImageView) viewHolder.getView(R.id.item_Iv)));
        } else if (type == FOOT) {
            ((TextView) viewHolder.getView(R.id.tv_layout_order_item_foot_total_price)).setText("$ " + mDatas.get(position).getOrder_total());
        }


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public int getContentType(int position) {
        return (int) (Math.log10(mDatas.get(position).getType()) / Math.log10(2));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> views = new SparseArray<>();

        public ViewHolder(View convertView) {
            super(convertView);
        }

        /**
         * 根据id获取view
         */
        public <T extends View> T getView(int viewId) {
            View view = views.get(viewId);
            if (null == view) {
                view = itemView.findViewById(viewId);
                views.put(viewId, view);
            }
            return (T) view;
        }
    }
}
