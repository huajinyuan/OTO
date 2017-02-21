package cn.gtgs.base.OTO.activity.center;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.ShopCar.ShoppingCarActivity;
import cn.gtgs.base.OTO.activity.center.view.CenterDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;

public class CenterActivity extends ActivityPresenter<CenterDelegate> {
    @Override
    protected void onInitPresenters() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected Class<CenterDelegate> getDelegateClass() {
        return CenterDelegate.class;
    }

    @OnClick({R.id.img_center_back, R.id.rel_center_go2shopcar, R.id.rel_center_order, R.id.rel_center_address, R.id.rel_center_information, R.id.rel_center_setting})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.img_center_back:
                this.finish();
                break;
            case R.id.rel_center_go2shopcar:
                Intent intent = new Intent(this, ShoppingCarActivity.class);
                startActivity(intent);
                break;
            case R.id.rel_center_order:
                break;
            case R.id.rel_center_address:
                break;
            case R.id.rel_center_information:
                break;
            case R.id.rel_center_setting:
                break;
        }
    }
}
