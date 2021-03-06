package cn.gtgs.base.OTO.http;


import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.DeleteRequest;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;
import com.lzy.okgo.request.PutRequest;

import java.io.IOException;

import cn.gtgs.base.OTO.OApplication;
import cn.gtgs.base.OTO.activity.login.model.Account;
import cn.gtgs.base.OTO.utils.ACache;
import cn.gtgs.base.OTO.utils.ACacheKey;
import okhttp3.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HttpMethods {
    private static HttpMethods httpMethods = null;
    private HttpHeaders heads = new HttpHeaders();

    public static HttpMethods getInstance() {
        if (httpMethods == null) {
            httpMethods = new HttpMethods();
        }
        return httpMethods;
    }


    public HttpParams getHttpParams() {
        HttpParams params = new HttpParams();//param支持中文,直接传,不要自己编码
        params.put("key", "E0yZjK6rBV1Lq47I1k7QPuN2LmADsXLS");
        return params;
    }

    public HttpHeaders getHeaders() {
        HttpHeaders heads = new HttpHeaders(); //header不支持中文，不允许有特殊字符
        ACache aCache = ACache.get(OApplication.getInstance());
        Account account = (Account) aCache.getAsObject(ACacheKey.CURRENT_ACCOUNT);
        heads.put("Authorization", "Bearer " + account.getToken());
        return heads;
    }

    public Observable<Response> doPost(PostRequest request, boolean isSetHeaders) {
        if (isSetHeaders) {
            request.headers(getHeaders());
        }
        return Observable.just(request).map(new Func1<PostRequest, Response>() {
            @Override
            public Response call(PostRequest request) {
                Response response = null;
                try {
                    response = request.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response> doPut(PutRequest request, boolean isSetHeaders) {
        if (isSetHeaders) {
            request.headers(getHeaders());
        }
        return Observable.just(request).map(new Func1<PutRequest, Response>() {
            @Override
            public Response call(PutRequest request) {
                Response response = null;
                try {
                    response = request.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response> doDelete(DeleteRequest request, boolean isSetHeaders) {
        if (isSetHeaders) {
            request.headers(getHeaders());
        }
        return Observable.just(request).map(new Func1<DeleteRequest, Response>() {
            @Override
            public Response call(DeleteRequest request) {
                Response response = null;
                try {
                    response = request.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response> doGet(GetRequest request, boolean isSetHeaders) {
        if (isSetHeaders) {
            request.headers(getHeaders());
        }
        return Observable.just(request).map(new Func1<GetRequest, Response>() {
            @Override
            public Response call(GetRequest request) {
                Response response = null;
                try {
                    response = request.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


}
