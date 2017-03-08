package cn.gtgs.base.OTO.activity.home.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.GetRequest;

import java.util.ArrayList;

import cn.gtgs.base.OTO.activity.comment.model.CurrentUser;
import cn.gtgs.base.OTO.activity.home.model.ProductGoods;
import cn.gtgs.base.OTO.activity.home.view.HomeDelegate;
import cn.gtgs.base.OTO.base.model.CheckError;
import cn.gtgs.base.OTO.http.Config;
import cn.gtgs.base.OTO.http.HttpMethods;
import cn.gtgs.base.OTO.utils.ACache;
import cn.gtgs.base.OTO.utils.ACacheKey;
import cn.gtgs.base.OTO.utils.F;
import cn.gtgs.base.OTO.utils.Parsing;
import okhttp3.Response;
import rx.Subscriber;

/**
 * Created by gtgs on 2017/2/10.
 */

public class HomePresenter implements IHomePresenter {

    @Override
    public void initData(HomeDelegate delegate, IHomeListener listener) {
        getUserInfo(delegate);
        getProducts(delegate, listener);
    }

    /**
     * 获当前用户信息
     */
    private void getUserInfo(final HomeDelegate delegate) {
        HttpParams params = HttpMethods.getInstance().getHttpParams();
        GetRequest request = OkGo.get(Config.CURRENT_URL).params(params);
        HttpMethods.getInstance().doGet(request, true).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response response) {
                CurrentUser user = Parsing.getInstance().ResponseToObject(response, CurrentUser.class);
                if (user.getCode() == 200) {
                    ACache.get(delegate.getActivity()).put(ACacheKey.CURRENT_USER, user);
                    F.e(((CurrentUser) (ACache.get(delegate.getActivity()).getAsObject(ACacheKey.CURRENT_USER))).toString());
                }
            }
        });
    }

    /**
     * 获取商品列表
     */
    private void getProducts(final HomeDelegate delegate, final IHomeListener listener) {
        HttpParams params = HttpMethods.getInstance().getHttpParams();
        GetRequest request = OkGo.get(Config.PRODUCTS_LIST_URL).params(params);
        HttpMethods.getInstance().doGet(request, false).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                F.e(e.toString());
            }

            @Override
            public void onNext(Response response) {
                CheckError checkError = Parsing.getInstance().parsingError(response);
                if (checkError.isSuccess()) {
                    ArrayList<ProductGoods> data = Parsing.getInstance().ResponseToList(response, ProductGoods.class);
                    delegate.setData(data);
                } else {
                    Parsing.getInstance().parsingError(response);
                    listener.RequstFailed(Parsing.getInstance().parsingError(response).getBaseError().getMessage());
                }
            }
        });
    }

}
