package cn.gtgs.base.OTO.activity.orders;

import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.orders.presenter.IOrderPresenter;
import cn.gtgs.base.OTO.activity.orders.presenter.OrderPresenter;
import cn.gtgs.base.OTO.activity.orders.view.OrderDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

public class OrdersActivity extends ActivityPresenter<OrderDelegate> implements
        NRecyclerView.RefreshAndLoadingListener {


    IOrderPresenter mPresenter;

    @Override
    protected void onInitPresenters() {
        mPresenter = new OrderPresenter();
    }

    @Override
    protected void initData() {
        viewDelegate.setTitle();
        mPresenter.initData(viewDelegate);
        viewDelegate.getmNrecylerView().setOnRefreshAndLoadingListener(this);
    }

    @Override
    protected Class<OrderDelegate> getDelegateClass() {
        return OrderDelegate.class;
    }

    @OnClick({R.id.img_topbar_back})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.img_topbar_back:
                this.finish();
                break;
        }
    }

    @Override
    public void refresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (null != viewDelegate &&null != viewDelegate.getmNrecylerView() && viewDelegate.getmNrecylerView().isRefreshing()) {
                    viewDelegate.getmNrecylerView().endRefresh();
                }
            }
        }, 2000);
    }

    @Override
    public void load() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (null != viewDelegate &&null != viewDelegate.getmNrecylerView() && viewDelegate.getmNrecylerView().isLoadingMore()) {
                    viewDelegate.getmNrecylerView().endLoadingMore();
                }
            }
        }, 2000);
    }
}
