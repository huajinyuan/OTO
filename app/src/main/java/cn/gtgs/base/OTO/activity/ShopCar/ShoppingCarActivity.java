package cn.gtgs.base.OTO.activity.ShopCar;

import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.ShopCar.presenter.ShoppingCarPresenter;
import cn.gtgs.base.OTO.activity.ShopCar.view.ShoppingDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

public class ShoppingCarActivity extends ActivityPresenter<ShoppingDelegate> implements NRecyclerView.RefreshAndLoadingListener {

    ShoppingCarPresenter mShoppingCarPresenter;

    @Override
    protected void onInitPresenters() {
        mShoppingCarPresenter = new ShoppingCarPresenter();
    }

    @Override
    protected void initData() {
        mShoppingCarPresenter.initData(viewDelegate);
        viewDelegate.getmNrecylerView().setOnRefreshAndLoadingListener(this);
    }

    @Override
    protected Class getDelegateClass() {
        return ShoppingDelegate.class;
    }

    @OnClick({R.id.img_shoppingcar_back, R.id.tv_shoppingcar_allchoose, R.id.btn_shopping_car_submit})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.img_shoppingcar_back:
                this.finish();
                break;
            case R.id.tv_shoppingcar_allchoose:
                viewDelegate.setAllChooseOrUnChoose();
                break;
            case R.id.btn_shopping_car_submit:
                mShoppingCarPresenter.initData(viewDelegate);
                break;
        }
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
}
