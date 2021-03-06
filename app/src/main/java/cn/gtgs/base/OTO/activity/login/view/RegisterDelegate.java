package cn.gtgs.base.OTO.activity.login.view;

import android.widget.EditText;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.base.view.AppDelegate;

/**
 * Created by gtgs on 2017/1/13.
 */

public class RegisterDelegate extends AppDelegate {
    @BindView(R.id.edt_register_userName)
    EditText mEdtAccount;
    @BindView(R.id.edt_register_password)
    EditText mEdtPassword;
    @BindView(R.id.edt_register_password2)
    EditText mEdtPassword2;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_register;
    }

    public String getAccount()
    {
        return mEdtAccount.getText().toString();
    }
    public String getPassWord()
    {
        return mEdtPassword.getText().toString();
    }
    public String getPassWords()
    {
        return mEdtPassword2.getText().toString();
    }

}
