package cn.gtgs.base.OTO.activity.orders.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.orders.model.NewOrderData;
import cn.gtgs.base.OTO.base.view.AppDelegate;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

/**
 * Created by gtgs on 2017/1/13.
 */

public class OrderDelegate extends AppDelegate {
    @BindView(R.id.nrec_orders_content)
    NRecyclerView mNrecylerView;
    @BindView(R.id.tv_topbar_title)
    TextView mTvTitle;
    OrderAdatper adatper;
    ArrayList<NewOrderData> mDatas = new ArrayList<>();

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_orders;
    }

    public void setData(ArrayList<NewOrderData> data) {
        GridLayoutManager layoutManager = new GridLayoutManager(getRootView().getContext(), 1);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNrecylerView.setLayoutManager(layoutManager);
        if (null == mDatas || mDatas.isEmpty()) {
            ViewGroup errorView = (ViewGroup) LayoutInflater.from(getRootView().getContext()).inflate(R.layout.layout_shopping_car_error, null);
            mNrecylerView.setEntryView(errorView);

        } else {
            mDatas.clear();
            mDatas.addAll(data);
            adatper = new OrderAdatper(mDatas, getRootView().getContext());
            mNrecylerView.setAdapter(adatper);
        }

    }

    public NRecyclerView getmNrecylerView() {
        return mNrecylerView;
    }

    public void setTitle() {
        mTvTitle.setText("My Orders");
    }

}
