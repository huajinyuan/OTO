package cn.gtgs.base.OTO.activity.login.presenter;

import cn.gtgs.base.OTO.activity.login.model.Account;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface IRegisterListener {
    void AccountError();

    void PassWordError();

    void PassWordDifferent();

    void RegisterSuccess(Account account);

    void RegisterFailed(String msg);
}
