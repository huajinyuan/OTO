package cn.gtgs.base.OTO.activity.buy.presenter;

import cn.gtgs.base.OTO.activity.buy.view.BuyNowDelegate;
import cn.gtgs.base.OTO.activity.home.model.ProductGoods;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface IBuyNowPresenter {
    void initData(BuyNowDelegate delegate , ProductGoods goods);
}
