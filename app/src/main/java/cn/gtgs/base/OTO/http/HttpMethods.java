package cn.gtgs.base.OTO.http;


import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;

import java.io.IOException;

import okhttp3.Response;
import rx.Observable;
import rx.functions.Func1;

public class HttpMethods {

    public static Observable<Response> doPost(PostRequest request) {
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
        });
    }

    public static Observable<Response> doGet(GetRequest request) {
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
        });
    }


}
