package cn.gtgs.base.OTO.activity.Information.view;

import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.login.model.User;
import cn.gtgs.base.OTO.base.view.AppDelegate;

/**
 * Created by gtgs on 2017/1/13.
 */

public class InformationDelegate extends AppDelegate {
    @BindView(R.id.tv_topbar_title)
    TextView mTvTitle;
    @BindView(R.id.tv_information_name)
    TextView mTvName;
    @BindView(R.id.tv_information_gender)
    TextView mTvGender;
    @BindView(R.id.tv_information_phone)
    TextView mTvPhone;
    @BindView(R.id.edt_information_password)
    EditText mEdtPassword;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_information;
    }

    public void setData(User data) {
    }

    public void setTitle() {
        mTvTitle.setText("Personal Information");
    }

}
