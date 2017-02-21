package cn.gtgs.base.OTO.activity.login.presenter;

import cn.gtgs.base.OTO.activity.login.view.LoginDelegate;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface ILoginPresenter {
     void login(LoginDelegate delegate , ILoginListener listener );
}
