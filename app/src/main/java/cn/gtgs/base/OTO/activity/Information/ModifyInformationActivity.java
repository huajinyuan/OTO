package cn.gtgs.base.OTO.activity.Information;

import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.Information.view.ModifyInformationDelegate;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;

public class ModifyInformationActivity extends ActivityPresenter<ModifyInformationDelegate> {


    @Override
    protected void onInitPresenters() {

    }

    @Override
    protected void initData() {
        viewDelegate.setTitle();
    }

    @Override
    protected Class<ModifyInformationDelegate> getDelegateClass() {
        return ModifyInformationDelegate.class;
    }

    @OnClick({R.id.img_topbar_back})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.img_topbar_back:
                this.finish();
                break;
        }
    }
}
