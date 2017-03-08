package cn.gtgs.base.OTO.activity.home;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.center.CenterActivity;
import cn.gtgs.base.OTO.activity.home.presenter.HomePresenter;
import cn.gtgs.base.OTO.activity.home.presenter.IHomeListener;
import cn.gtgs.base.OTO.activity.home.view.HomeDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;
import cn.gtgs.base.OTO.utils.ToastUtil;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

public class HomeActivity extends ActivityPresenter<HomeDelegate> implements IHomeListener,
        NRecyclerView.RefreshAndLoadingListener {
    HomePresenter mHomePresenter;
    Intent intent;

    @Override
    protected void onInitPresenters() {
        mHomePresenter = new HomePresenter();
    }

    @Override
    protected void initData() {
        mHomePresenter.initData(viewDelegate, this);
        viewDelegate.getmNrecylerView().setOnRefreshAndLoadingListener(this);
    }

    @OnClick({R.id.img_home_center, R.id.img_home_qr_action})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.img_home_center:
                intent = new Intent(this, CenterActivity.class);
                startActivity(intent);
                break;
            case R.id.img_home_qr_action:
                intent = new Intent(this, QrCodeActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected Class getDelegateClass() {
        return HomeDelegate.class;
    }

    @Override
    public void refresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (null != viewDelegate && null != viewDelegate.getmNrecylerView() && viewDelegate.getmNrecylerView().isRefreshing()) {
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
                if (null != viewDelegate && null != viewDelegate.getmNrecylerView() && viewDelegate.getmNrecylerView().isLoadingMore()) {
                    viewDelegate.getmNrecylerView().endLoadingMore();
                }
            }
        }, 2000);
    }

    @Override
    public void RequstSuccess() {

    }

    @Override
    public void RequstFailed(String msg) {
        ToastUtil.showToast(msg, this);
    }
}
