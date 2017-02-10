package cn.gtgs.base.mymvp.activity.login;

import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.mymvp.R;
import cn.gtgs.base.mymvp.activity.login.model.Student;
import cn.gtgs.base.mymvp.activity.login.presenter.ILoginPresenter;
import cn.gtgs.base.mymvp.activity.login.presenter.LoginPresenter;
import cn.gtgs.base.mymvp.activity.login.presenter.Student2MainBinder;
import cn.gtgs.base.mymvp.activity.login.view.LoginDelegate;
import cn.gtgs.base.mymvp.base.presenter.databind.DataBindActivity;
import cn.gtgs.base.mymvp.base.presenter.databind.DataBinder;

public class LoginActivity extends DataBindActivity<LoginDelegate> {
    Student mStudent = new Student("晓", "男", 1);
    ILoginPresenter mLoginPresenter;
    @Override
    protected Class<LoginDelegate> getDelegateClass() {
        return LoginDelegate.class;
    }

    @OnClick( R.id.btn_main_action)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_action:
//                mStudent.setUserName("小B");
//                notifyModelChanged(mStudent);
                mLoginPresenter.login(viewDelegate);
                break;
        }
    }

    @Override
    protected void onInitPresenters() {
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public DataBinder getDataBinder() {
        return new Student2MainBinder();
    }
}
