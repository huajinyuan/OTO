package cn.gtgs.base.OTO.activity.home;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.center.CenterActivity;
import cn.gtgs.base.OTO.activity.home.presenter.HomePresenter;
import cn.gtgs.base.OTO.activity.home.view.HomeDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

public class HomeActivity extends ActivityPresenter<HomeDelegate> implements
        NRecyclerView.RefreshAndLoadingListener {
    HomePresenter mHomePresenter;

    @Override
    protected void onInitPresenters() {
        mHomePresenter = new HomePresenter();
    }

    @Override
    protected void initData() {
        mHomePresenter.initData(viewDelegate);
        viewDelegate.getmNrecylerView().setOnRefreshAndLoadingListener(this);
    }

    @OnClick({R.id.img_home_center})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.img_home_center:
                Intent intent = new Intent(this, CenterActivity.class);
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
        viewDelegate.getmNrecylerView().endRefresh();
    }

    @Override
    public void load() {
        viewDelegate.getmNrecylerView().endLoadingMore();
    }
}
