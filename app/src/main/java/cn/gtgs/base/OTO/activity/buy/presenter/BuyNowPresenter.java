package cn.gtgs.base.OTO.activity.buy.presenter;

import com.damnhandy.uri.template.UriTemplate;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.GetRequest;

import cn.gtgs.base.OTO.activity.buy.view.BuyNowDelegate;
import cn.gtgs.base.OTO.activity.home.model.ProductGoods;
import cn.gtgs.base.OTO.http.Config;
import cn.gtgs.base.OTO.http.HttpMethods;
import okhttp3.Response;
import rx.Subscriber;

/**
 * Created by gtgs on 2017/2/22.
 */

public class BuyNowPresenter implements IBuyNowPresenter {
//    @Override
//    public void initData(BuyNowDelegate delegate,Pr) {
////        ArrayList<String> size = new ArrayList<>();
////        size.add("350ml");
////        size.add("500ml");
////        size.add("800ml");
////        size.add("1000ml");
////        size.add("1200ml");
////        size.add("1500ml");
////        delegate.setSizeData(size);
////        ArrayList<String> colors = new ArrayList<>();
////        colors.add("Red");
////        colors.add("Black");
////        colors.add("Yellow");
////        colors.add("Pink");
////        colors.add("White");
////        colors.add("Silver");
////        delegate.setColorData(colors);
//
//
//
//    }

    @Override
    public void initData(BuyNowDelegate delegate, ProductGoods goods) {
        String url = UriTemplate.fromTemplate(Config.PRODUCTS_URL).set("id", goods.getId()).expand();
        HttpParams params = HttpMethods.getInstance().getHttpParams();
        GetRequest request = OkGo.get(url).params(params);
        HttpMethods.getInstance().doGet(request, false).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response response) {

            }
        });

    }
}
