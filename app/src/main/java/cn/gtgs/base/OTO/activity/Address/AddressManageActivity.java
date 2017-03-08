package cn.gtgs.base.OTO.activity.Address;

import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.activity.Address.presenter.AddressManagePresenter;
import cn.gtgs.base.OTO.activity.Address.presenter.IAddressActionLisenter;
import cn.gtgs.base.OTO.activity.Address.presenter.IAddressManagePresenter;
import cn.gtgs.base.OTO.activity.Address.view.AddressManageDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;
import cn.gtgs.base.OTO.utils.IntentKey;
import cn.gtgs.base.OTO.utils.ToastUtil;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;
import cn.gtgs.base.OTO.widget.SweetAlert.SweetAlertDialog;

public class AddressManageActivity extends ActivityPresenter<AddressManageDelegate> implements
        NRecyclerView.RefreshAndLoadingListener, IAddressActionLisenter {
    IAddressManagePresenter presenter;
    Intent mIntent;

    @Override
    protected void onInitPresenters() {
        presenter = new AddressManagePresenter(viewDelegate, this);
    }

    @Override
    protected void initData() {
        viewDelegate.setTitle();
        presenter.initData();
        viewDelegate.getmNrecylerView().setOnRefreshAndLoadingListener(this);
    }

    @Override
    protected Class<AddressManageDelegate> getDelegateClass() {
        return AddressManageDelegate.class;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.initData();
    }

    @OnClick({R.id.img_topbar_back, R.id.btn_address_manage_add})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.img_topbar_back:
                this.finish();
                break;
            case R.id.btn_address_manage_add:
                mIntent = new Intent(this, CreatAddressActivity.class);
                startActivity(mIntent);
                break;
        }
    }

    @Override
    public void refresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (null != viewDelegate && null != viewDelegate.getmNrecylerView() && viewDelegate.getmNrecylerView().isRefreshing()) {
                    viewDelegate.getmNrecylerView().endRefresh();
                }
            }
        }, 2000);
    }

    @Override
    public void load() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (null != viewDelegate && null != viewDelegate.getmNrecylerView() && viewDelegate.getmNrecylerView().isLoadingMore()) {
                    viewDelegate.getmNrecylerView().endLoadingMore();
                }
            }
        }, 2000);
    }

    @Override
    public void change(ArrayList<Address> mDatas) {

    }

    @Override
    public void deleteItem(final Address address) {
        final SweetAlertDialog dialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        dialog.setTitleText("Delete Address");
        dialog.setContentText("product information is consistent with the distribution of goods.");
        dialog.showCancelButton(true);
        dialog.setCancelText("NO");
        dialog.setConfirmText("YES");
        dialog.show();
        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                presenter.deleteAddress(address);
                dialog.dismissWithAnimation();
            }
        });
    }

    @Override
    public void modifyItem(Address address) {
        mIntent = new Intent(this, CreatAddressActivity.class);
        mIntent.putExtra(IntentKey.ADDRESSTOMODIFY, address);
        startActivity(mIntent);
    }

    @Override
    public void doActionSussese() {
        ToastUtil.showToast("Sussese!", this);
        presenter.initData();
    }

    @Override
    public void doActionFailed(String msg) {
        ToastUtil.showToast(msg, this);
    }
}
