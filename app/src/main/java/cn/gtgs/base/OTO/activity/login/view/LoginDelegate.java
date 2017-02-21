package cn.gtgs.base.OTO.activity.login.view;

import android.widget.EditText;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.base.view.AppDelegate;

/**
 * Created by gtgs on 2017/1/13.
 */

public class LoginDelegate extends AppDelegate {
    @BindView(R.id.edt_login_username)
    EditText mEdtUserName;
    @BindView(R.id.edt_login_password)
    EditText mEdtPassword;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_login;
    }

    public String getUserName()
    {
        return mEdtUserName.getText().toString();
    }
    public String getPassWord()
    {
        return mEdtPassword.getText().toString();
    }

}
