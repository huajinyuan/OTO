package cn.gtgs.base.OTO.activity.home.presenter;

import java.util.ArrayList;

import cn.gtgs.base.OTO.activity.home.view.HomeDelegate;

/**
 * Created by gtgs on 2017/2/10.
 */

public class HomePresenter implements IHomePresenter {

    @Override
    public void initData(HomeDelegate delegate) {
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
