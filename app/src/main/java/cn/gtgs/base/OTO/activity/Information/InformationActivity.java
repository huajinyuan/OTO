package cn.gtgs.base.OTO.activity.Information;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.Information.view.InformationDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;

public class InformationActivity extends ActivityPresenter<InformationDelegate> {


    @Override
    protected void onInitPresenters() {

    }

    @Override
    protected void initData() {
        viewDelegate.setTitle();

    }

    @Override
    protected Class getDelegateClass() {
        return InformationDelegate.class;
    }

    @OnClick({R.id.img_topbar_back, R.id.btn_information_modify})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.img_topbar_back:
                this.finish();
                break;
            case R.id.btn_information_modify:
                Intent intent = new Intent(this, ModifyInformationActivity.class);
                startActivity(intent);
                break;

        }
    }
}
