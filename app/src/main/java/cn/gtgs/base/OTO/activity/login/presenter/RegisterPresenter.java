package cn.gtgs.base.OTO.activity.login.presenter;

import cn.gtgs.base.OTO.activity.login.view.RegisterDelegate;
import cn.gtgs.base.OTO.utils.StringUtils;

/**
 * Created by gtgs on 2017/2/10.
 */

public class RegisterPresenter implements IRegisterPresenter {
    @Override
    public void register(RegisterDelegate delegate, final IRegisterListener listener) {
        if (StringUtils.isEmpty(delegate.getAccount())) {
            listener.AccountError();
            return;
        }
        if (StringUtils.isEmpty(delegate.getPassWord())) {
            listener.PassWordError();
            return;
        }
        if (StringUtils.isEmpty(delegate.getPassWords()) || !delegate.getPassWord().equals(delegate.getPassWords())) {
            listener.PassWordDifferent();
            return;
        }
/**
 * 接口测试
 * */

//        PostRequest request = OkGo.post(Config.REGISTER_URL).tag(this).headers("header1", "headerValue1")
//                .params("param1", "paramValue1");
//        HttpMethods.doPost(request).subscribe(new Subscriber<Response>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Response response) {
////                Account account = Parsing.ResponseToLogin(response); //接口测试
//                listener.RegisterSuccess();
//
//            }
//        });


    }
}
