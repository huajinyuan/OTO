package cn.gtgs.base.OTO.activity.login.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.PostRequest;

import cn.gtgs.base.OTO.activity.login.model.Account;
import cn.gtgs.base.OTO.activity.login.view.LoginDelegate;
import cn.gtgs.base.OTO.http.Config;
import cn.gtgs.base.OTO.http.HttpMethods;
import cn.gtgs.base.OTO.utils.F;
import cn.gtgs.base.OTO.utils.Parsing;
import cn.gtgs.base.OTO.utils.StringUtils;
import okhttp3.Response;
import rx.Subscriber;

/**
 * Created by gtgs on 2017/2/10.
 */

public class LoginPresenter implements ILoginPresenter {

    @Override
    public void login(LoginDelegate delegate, final ILoginListener listener) {
        if (StringUtils.isEmpty(delegate.getUserName())) {
            listener.UserNameError();
            return;
        }
        if (StringUtils.isEmpty(delegate.getPassWord())) {
            listener.PassWordError();
            return;
        }
        HttpParams params = HttpMethods.getInstance().getHttpParams();
        params.put("email", delegate.getUserName());
        params.put("password", delegate.getPassWord());
        PostRequest request = OkGo.post(Config.LOGIN_URL)
                .params(params);
        HttpMethods.getInstance().doPost(request, false).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                F.e(e.toString());
            }

            @Override
            public void onNext(Response response) {
//                Account account = Parsing.getInstance().ResponseToLogin(response); //接口测试
                Account account = Parsing.getInstance().ResponseToObject(response, Account.class);
                if (account.getCode() == 200) {
                    listener.LoginSuccess(account);
                } else {
                    listener.LoginFailed(account.getMessage());
                }

            }
        });


    }
}
