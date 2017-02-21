package cn.gtgs.base.OTO.activity.login.presenter;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface IRegisterListener {
    void AccountError();

    void PassWordError();

    void PassWordDifferent();

    void RegisterSuccess();
}
