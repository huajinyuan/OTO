package cn.gtgs.base.mymvp.activity.login.presenter;

import cn.gtgs.base.mymvp.activity.login.view.LoginDelegate;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface ILoginPresenter {
    public void login(LoginDelegate delegate ,ILoginListener listener );
}
