package cn.gtgs.base.OTO.activity.login.presenter;

import cn.gtgs.base.OTO.activity.login.view.RegisterDelegate;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface IRegisterPresenter {
    void register(RegisterDelegate delegate, IRegisterListener listener);
}
