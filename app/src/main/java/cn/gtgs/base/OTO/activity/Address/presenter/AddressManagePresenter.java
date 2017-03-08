package cn.gtgs.base.OTO.activity.Address.presenter;

import com.damnhandy.uri.template.UriTemplate;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.DeleteRequest;
import com.lzy.okgo.request.GetRequest;

import java.util.ArrayList;

import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.activity.Address.view.AddressManageDelegate;
import cn.gtgs.base.OTO.base.model.CheckError;
import cn.gtgs.base.OTO.http.Config;
import cn.gtgs.base.OTO.http.HttpMethods;
import cn.gtgs.base.OTO.utils.Parsing;
import okhttp3.Response;
import rx.Subscriber;

/**
 * Created by gtgs on 2017/2/22.
 */

public class AddressManagePresenter implements IAddressManagePresenter {
    private AddressManageDelegate delegate;
    private IAddressActionLisenter lisenter;

    public AddressManagePresenter(AddressManageDelegate delegate, IAddressActionLisenter lisenter) {
        this.delegate = delegate;
        this.lisenter = lisenter;
    }

    @Override
    public void initData() {
        HttpParams params = HttpMethods.getInstance().getHttpParams();
        GetRequest request = OkGo.get(Config.ADDRESS_URL).params(params);
        HttpMethods.getInstance().doGet(request, true).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response response) {
                if (Parsing.getInstance().checkNotError(response)) {
                    ArrayList<Address> addresses = Parsing.getInstance().ResponseToList(response, Address.class);
                    delegate.setData(addresses, lisenter);
                } else {
                    delegate.setData(null, null);
                }
            }
        });

    }

    @Override
    public void deleteAddress(Address address) {
        String url = UriTemplate.fromTemplate(Config.ADDRESS_ACTION_URL)
                .set("id", address.getId())
                .expand();

        HttpParams params = HttpMethods.getInstance().getHttpParams();
        DeleteRequest request = OkGo.delete(url).params(params);
        HttpMethods.getInstance().doDelete(request, true).subscribe(new Subscriber<Response>() {
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
                    lisenter.doActionSussese();
                } else {
                    lisenter.doActionFailed(checkError.getBaseError().getMessage());
                }
            }
        });
    }

}
