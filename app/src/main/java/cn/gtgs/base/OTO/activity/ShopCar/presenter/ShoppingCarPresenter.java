package cn.gtgs.base.OTO.activity.ShopCar.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.GetRequest;

import java.util.ArrayList;

import cn.gtgs.base.OTO.activity.ShopCar.model.ShopCarGoods;
import cn.gtgs.base.OTO.activity.ShopCar.view.ShoppingDelegate;
import cn.gtgs.base.OTO.base.model.CheckError;
import cn.gtgs.base.OTO.http.Config;
import cn.gtgs.base.OTO.http.HttpMethods;
import cn.gtgs.base.OTO.utils.Parsing;
import okhttp3.Response;
import rx.Subscriber;

/**
 * Created by gtgs on 2017/2/10.
 */

public class ShoppingCarPresenter implements IShoppingCarPresenter {

    @Override
    public void initData(final ShoppingDelegate delegate) {
        HttpParams params = HttpMethods.getInstance().getHttpParams();
        GetRequest request = OkGo.get(Config.SHOPPINGCAR_LIST_URL).params(params);
        HttpMethods.getInstance().doGet(request, true).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response response) {
                CheckError checkError = Parsing.getInstance().parsingError(response);
                if (checkError.isSuccess()) {
                    ArrayList<ShopCarGoods> goodses = Parsing.getInstance().ResponseToShoppingCar(response);
                    delegate.setData(goodses);
                } else {

                }


            }
        });

    }

    @Override
    public void CreateOrder(ShoppingDelegate delegate) {

    }

}
