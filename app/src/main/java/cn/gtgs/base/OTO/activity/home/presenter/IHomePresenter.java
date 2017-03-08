package cn.gtgs.base.OTO.activity.home.presenter;

import cn.gtgs.base.OTO.activity.home.view.HomeDelegate;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface IHomePresenter {
    void initData(HomeDelegate delegate, IHomeListener listener);
}
