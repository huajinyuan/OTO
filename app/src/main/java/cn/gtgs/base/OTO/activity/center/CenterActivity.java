package cn.gtgs.base.OTO.activity.center;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.Address.AddressManageActivity;
import cn.gtgs.base.OTO.activity.Information.InformationActivity;
import cn.gtgs.base.OTO.activity.ShopCar.ShoppingCarActivity;
import cn.gtgs.base.OTO.activity.center.view.CenterDelegate;
import cn.gtgs.base.OTO.activity.comment.model.CurrentUser;
import cn.gtgs.base.OTO.activity.orders.OrdersActivity;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;
import cn.gtgs.base.OTO.utils.ACacheKey;
import cn.gtgs.base.OTO.widget.SweetAlert.SweetAlertDialog;

public class CenterActivity extends ActivityPresenter<CenterDelegate> {
    Intent intent;
    CurrentUser mCurrentUser;

    @Override
    protected void onInitPresenters() {

    }

    @Override
    protected void initData() {
        mCurrentUser = (CurrentUser) mACache.getAsObject(ACacheKey.CURRENT_USER);
        viewDelegate.setName(mCurrentUser.getUsername());
        viewDelegate.setPhone(mCurrentUser.getPhone_number());
    }

    @Override
    protected Class<CenterDelegate> getDelegateClass() {
        return CenterDelegate.class;
    }

    @OnClick({R.id.img_center_back, R.id.rel_center_go2shopcar, R.id.rel_center_order, R.id.rel_center_address, R.id.rel_center_information, R.id.rel_center_setting, R.id.lin_center_information})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.lin_center_information:
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Information")
                        .setContentText("Something went wrong!")
                        .show();
                break;
            case R.id.img_center_back:
                this.finish();
                break;
            case R.id.rel_center_go2shopcar:
                intent = new Intent(this, ShoppingCarActivity.class);
                startActivity(intent);
                break;
            case R.id.rel_center_order:
                intent = new Intent(this, OrdersActivity.class);
                startActivity(intent);
//                new SweetAlertDialog(this)
//                        .setContentText("It's pretty, isn't it?")
//                        .show();
                break;
            case R.id.rel_center_address:
//                SweetAlertDialog sd = new SweetAlertDialog(this);
//                sd.setCancelable(true);
//                sd.setCanceledOnTouchOutside(true);
//                sd.show();
                intent = new Intent(this, AddressManageActivity.class);
                startActivity(intent);
                break;
            case R.id.rel_center_information:
                intent = new Intent(this, InformationActivity.class);
                startActivity(intent);
                break;
            case R.id.rel_center_setting:
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Setting")
                        .setContentText("You clicked the button!")
                        .show();
                break;
        }
    }
}
