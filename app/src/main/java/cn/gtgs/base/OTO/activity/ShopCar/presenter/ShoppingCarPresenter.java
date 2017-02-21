package cn.gtgs.base.OTO.activity.ShopCar.presenter;

import java.util.ArrayList;

import cn.gtgs.base.OTO.activity.ShopCar.view.ShoppingDelegate;

/**
 * Created by gtgs on 2017/2/10.
 */

public class ShoppingCarPresenter implements IShoppingCarPresenter {

    @Override
    public void initData(ShoppingDelegate delegate) {
        ArrayList<String> data = new ArrayList<>();
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        data.add("E");
        data.add("F");
        data.add("G");
        delegate.setData(data);
    }

}
