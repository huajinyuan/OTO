package cn.gtgs.base.OTO.activity.Address.view;

import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.base.view.AppDelegate;

/**
 * Created by gtgs on 2017/1/13.
 */

public class CreateddressDelegate extends AppDelegate {
    @BindView(R.id.tv_topbar_title)
    TextView mTvTitle;
    @BindView(R.id.edt_create_address_firstname)
    EditText mEdtFirstName;
    @BindView(R.id.edt_create_address_lastname)
    EditText mEdtLastName;
    @BindView(R.id.edt_create_address_phone_number)
    EditText mEdtPhone;
    @BindView(R.id.edt_create_address_country)
    EditText mEdtCountry;
    @BindView(R.id.edt_create_address_state)
    EditText mEdtState;
    @BindView(R.id.edt_create_address_detail_address)
    EditText mEdtDetailAddress;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_creat_address;
    }


    public void setTitle(String title) {
        if (null == title) {
            mTvTitle.setText("New Address");
        } else {
            mTvTitle.setText(title);
        }
    }

    public void setFirstNameText(String firstName) {
        mEdtFirstName.setText(firstName);
    }

    public String getFirstName() {
        return mEdtFirstName.getText().toString();
    }

    public void setLastNameText(String firstName) {
        mEdtLastName.setText(firstName);
    }

    public String getLastName() {
        return mEdtLastName.getText().toString();
    }

    public void setPhoneText(String phone) {
        mEdtPhone.setText(phone);
    }

    public String getPhone() {
        return mEdtPhone.getText().toString();
    }

    public void setCountryText(String country) {
        mEdtCountry.setText(country);
    }

    public String getCountry() {
        return mEdtCountry.getText().toString();
    }

    public void setStateText(String state) {
        mEdtState.setText(state);
    }

    public String getState() {
        return mEdtState.getText().toString();
    }

    public void setDetailAddress(String detailaddress) {
        mEdtDetailAddress.setText(detailaddress);
    }

    public String getDetailAddress() {
        return mEdtDetailAddress.getText().toString();
    }

    public void initAddress(Address address) {
        setFirstNameText(address.getFirst_name());
        setLastNameText(address.getLast_name());
        setPhoneText(address.getPhone_number());
        setCountryText(address.getCountry());
        setStateText(address.getState());
        setDetailAddress(address.getAddress());
    }

}
