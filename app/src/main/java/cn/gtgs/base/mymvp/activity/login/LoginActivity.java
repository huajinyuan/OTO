package cn.gtgs.base.mymvp.activity.login;

import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.mymvp.R;
import cn.gtgs.base.mymvp.activity.login.model.Student;
import cn.gtgs.base.mymvp.activity.login.presenter.ILoginListener;
import cn.gtgs.base.mymvp.activity.login.presenter.ILoginPresenter;
import cn.gtgs.base.mymvp.activity.login.presenter.LoginPresenter;
import cn.gtgs.base.mymvp.activity.login.presenter.Student2MainBinder;
import cn.gtgs.base.mymvp.activity.login.view.LoginDelegate;
import cn.gtgs.base.mymvp.base.presenter.databind.DataBindActivity;
import cn.gtgs.base.mymvp.base.presenter.databind.DataBinder;
import cn.gtgs.base.mymvp.utils.ToastUtil;

public class LoginActivity extends DataBindActivity<LoginDelegate> implements ILoginListener {
    Student mStudent = new Student("晓", "男", 1);
    ILoginPresenter mLoginPresenter;

    @Override
    protected Class<LoginDelegate> getDelegateClass() {
        return LoginDelegate.class;
    }

    @OnClick(R.id.btn_login_admin)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_admin:
//                mStudent.setUserName("小B");
//                notifyModelChanged(mStudent);
                mLoginPresenter.login(viewDelegate, this);
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

    @Override
    public void UserNameError() {
        ToastUtil.showToast("UserNameError",this);
    }

    @Override
    public void PassWordError() {
        ToastUtil.showToast("PassWordError",this);
    }

    @Override
    public void LoginSuccess() {
        ToastUtil.showToast("LoginSuccess",this);
    }
}
