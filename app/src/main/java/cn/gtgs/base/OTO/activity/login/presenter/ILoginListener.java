package cn.gtgs.base.OTO.activity.login.presenter;

import cn.gtgs.base.OTO.activity.login.model.Account;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface ILoginListener {
    void UserNameError();

    void PassWordError();

    void LoginSuccess( Account account);

    void LoginFailed(String msg);
}
