package cn.gtgs.base.mymvp.activity.login.presenter;

import cn.gtgs.base.mymvp.activity.login.model.User;
import cn.gtgs.base.mymvp.activity.login.view.LoginDelegate;
import cn.gtgs.base.mymvp.base.presenter.databind.DataBinder;

/**
 * Created by gtgs on 2017/1/13.
 */

public class Student2MainBinder implements DataBinder<LoginDelegate,User> {
    @Override
    public void viewBindModel(LoginDelegate viewDelegate, User data) {
//        viewDelegate.setTip(data.getUserName());
    }

}
