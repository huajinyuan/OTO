package cn.gtgs.base.OTO.activity.ShopCar;

import cn.gtgs.base.OTO.activity.ShopCar.presenter.ShoppingCarPresenter;
import cn.gtgs.base.OTO.activity.ShopCar.view.ShoppingDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;

public class ShoppingCarActivity extends ActivityPresenter<ShoppingDelegate> {

    ShoppingCarPresenter mShoppingCarPresenter;

    @Override
    protected void onInitPresenters() {
        mShoppingCarPresenter = new ShoppingCarPresenter();
    }

    @Override
    protected void initData() {
        mShoppingCarPresenter.initData(viewDelegate);
    }

    @Override
    protected Class getDelegateClass() {
        return ShoppingDelegate.class;
    }
}
