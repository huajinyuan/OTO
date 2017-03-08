package cn.gtgs.base.OTO.activity.Information.view;

import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.login.model.User;
import cn.gtgs.base.OTO.base.view.AppDelegate;

/**
 * Created by gtgs on 2017/1/13.
 */

public class ModifyInformationDelegate extends AppDelegate {
    @BindView(R.id.tv_topbar_title)
    TextView mTvTitle;
    @BindView(R.id.radio_modify_information_male)
    RadioButton mRadioBoxMale;
    @BindView(R.id.radio_modify_information_female)
    RadioButton mRadioBoxFemale;


    @Override
    public int getRootLayoutId() {
        return R.layout.activity_modify_information;
    }

    public void setData(User data) {
    }

    public void setTitle() {
        mTvTitle.setText("Modify Information");
    }

//    public void addCheckBoxListen() {
//        mCheckBoxMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                mIsMale = isChecked;
//            }
//        });
//        mCheckBoxFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                mIsMale = !isChecked;
//            }
//
//        });
//    }

}
