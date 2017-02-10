package cn.gtgs.base.mymvp.activity.login.presenter;

import android.content.Context;

import cn.gtgs.base.mymvp.activity.login.view.LoginDelegate;
import cn.gtgs.base.mymvp.utils.StringUtils;

/**
 * Created by gtgs on 2017/2/10.
 */

public class LoginPresenter implements ILoginPresenter {
    Context mContext;

    public LoginPresenter(Context mContext) {
        this.mContext = mContext;
    }

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
