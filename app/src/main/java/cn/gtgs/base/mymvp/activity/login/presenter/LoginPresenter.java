package cn.gtgs.base.mymvp.activity.login.presenter;

import android.content.Context;
import android.content.Intent;

import cn.gtgs.base.mymvp.activity.login.view.LoginDelegate;
import cn.gtgs.base.mymvp.activity.movietest.MovieTestActivity;
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
    public void login(LoginDelegate delegate) {
        if (StringUtils.isNotEmpty(delegate.getUserName())&& StringUtils.isNotEmpty(delegate.getPassWord()))
        {
            doLogin(delegate.getUserName(),delegate.getPassWord());
        }
    }
    public void doLogin(String account , String pwd)
    {
        Intent intent = new Intent(mContext, MovieTestActivity.class);
        mContext.startActivity(intent);
    }
}
