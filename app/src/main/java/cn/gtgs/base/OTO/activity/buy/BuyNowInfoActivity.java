package cn.gtgs.base.OTO.activity.buy;

import android.view.View;

import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.buy.presenter.BuyNowPresenter;
import cn.gtgs.base.OTO.activity.buy.presenter.IBuyNowPresenter;
import cn.gtgs.base.OTO.activity.buy.view.BuyNowDelegate;
import cn.gtgs.base.OTO.activity.home.model.ProductGoods;
import cn.gtgs.base.OTO.base.presenter.ActivityPresenter;
import cn.gtgs.base.OTO.utils.IntentKey;

public class BuyNowInfoActivity extends ActivityPresenter<BuyNowDelegate> {

    ProductGoods mProducts;
    IBuyNowPresenter presenter;

    @Override
    protected void onInitPresenters() {
        mProducts = (ProductGoods) getIntent().getSerializableExtra(IntentKey.PRODUCTTOBUY);
        presenter = new BuyNowPresenter();
    }

    @Override
    protected void initData() {
        viewDelegate.setTitle();
        presenter.initData(viewDelegate, mProducts);
    }

    @Override
    protected Class<BuyNowDelegate> getDelegateClass() {
        return BuyNowDelegate.class;
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
