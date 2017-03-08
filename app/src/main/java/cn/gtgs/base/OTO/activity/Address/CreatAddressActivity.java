package cn.gtgs.base.OTO.activity.Address;

import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.activity.Address.presenter.CreateAddressPresenter;
import cn.gtgs.base.OTO.activity.Address.presenter.ICreateListenter;
import cn.gtgs.base.OTO.activity.Address.view.CreateddressDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;
import cn.gtgs.base.OTO.utils.IntentKey;
import cn.gtgs.base.OTO.utils.ToastUtil;

public class CreatAddressActivity extends ActivityPresenter<CreateddressDelegate> implements ICreateListenter {
    CreateAddressPresenter presenter;
    Address mAddress;

    @Override
    protected void onInitPresenters() {
        mAddress = (Address) getIntent().getSerializableExtra(IntentKey.ADDRESSTOMODIFY);
        presenter = new CreateAddressPresenter(viewDelegate, this);
    }

    @Override
    protected void initData() {
        if (null != mAddress) {
            viewDelegate.initAddress(mAddress);
            viewDelegate.setTitle("Modify Address");
        } else {
            viewDelegate.setTitle(null);
        }
    }

    @Override
    protected Class<CreateddressDelegate> getDelegateClass() {
        return CreateddressDelegate.class;
    }

    @OnClick({R.id.btn_create_address_save, R.id.img_topbar_back})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_address_save:
                if (null != mAddress) {
                    presenter.Modify(mAddress);
                } else {
                    presenter.saveAddress();
                }
                break;
            case R.id.img_topbar_back:
                this.finish();
                break;
        }
    }

    @Override
    public void CreateSussess() {
        ToastUtil.showToast("Sussess", this);
        this.finish();
    }

    @Override
    public void CreateFailed(String msg) {
        ToastUtil.showToast(msg, this);
    }
}
