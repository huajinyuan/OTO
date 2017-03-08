package cn.gtgs.base.OTO.activity.login.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.PostRequest;

import cn.gtgs.base.OTO.activity.login.model.Account;
import cn.gtgs.base.OTO.activity.login.view.RegisterDelegate;
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

        HttpParams params = HttpMethods.getInstance().getHttpParams();
        params.put("email", delegate.getAccount());
        params.put("password", delegate.getPassWord());
        PostRequest request = OkGo.post(Config.REGISTER_URL)
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
                Account account = Parsing.getInstance().ResponseToObject(response, Account.class); //接口测试
                if (account.getCode() == 200) {
                    listener.RegisterSuccess(account);
                } else {
                    listener.RegisterFailed(account.getMessage());
                }

            }
        });

    }
}
