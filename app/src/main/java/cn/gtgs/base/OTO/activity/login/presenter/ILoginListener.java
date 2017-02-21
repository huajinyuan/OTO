package cn.gtgs.base.OTO.activity.login.presenter;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface ILoginListener {
    void UserNameError();

    void PassWordError();

    void LoginSuccess();
}
