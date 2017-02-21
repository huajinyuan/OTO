package cn.gtgs.base.OTO.activity.login.presenter;

import cn.gtgs.base.OTO.activity.login.view.LoginDelegate;
import cn.gtgs.base.OTO.utils.StringUtils;

/**
 * Created by gtgs on 2017/2/10.
 */

public class LoginPresenter implements ILoginPresenter {

    @Override
    public void login(LoginDelegate delegate, ILoginListener listener) {
        if (StringUtils.isEmpty(delegate.getUserName())) {
            listener.UserNameError();
            return;
        }
        if (StringUtils.isEmpty(delegate.getPassWord())) {
            listener.PassWordError();
            return;
        }
        listener.LoginSuccess();
    }
}
