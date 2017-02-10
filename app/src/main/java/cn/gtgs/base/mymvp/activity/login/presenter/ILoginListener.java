package cn.gtgs.base.mymvp.activity.login.presenter;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface ILoginListener {
    void UserNameError();

    void PassWordError();

    void LoginSuccess();
}
