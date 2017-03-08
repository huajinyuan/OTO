package cn.gtgs.base.OTO.activity.Address.presenter;

import com.damnhandy.uri.template.UriTemplate;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.PostRequest;
import com.lzy.okgo.request.PutRequest;

import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.activity.Address.view.CreateddressDelegate;
import cn.gtgs.base.OTO.base.model.CheckError;
import cn.gtgs.base.OTO.http.Config;
import cn.gtgs.base.OTO.http.HttpMethods;
import cn.gtgs.base.OTO.utils.Parsing;
import cn.gtgs.base.OTO.utils.StringUtils;
import okhttp3.Response;
import rx.Subscriber;

/**
 * Created by gtgs on 2017/3/7.
 */

public class CreateAddressPresenter implements ICreateAddressPresenter {
    private CreateddressDelegate delegate;
    private ICreateListenter listenter;

    public CreateAddressPresenter(CreateddressDelegate delegate, ICreateListenter listenter) {
        this.delegate = delegate;
        this.listenter = listenter;
    }

    @Override
    public void initData(Address address) {
        delegate.initAddress(address);
    }

    @Override
    public void saveAddress() {
        if (StringUtils.isEmpty(delegate.getFirstName())) {
            listenter.CreateFailed("FirstName Empty");
            return;
        }
        if (StringUtils.isEmpty(delegate.getLastName())) {
            listenter.CreateFailed("LastName Empty");
            return;
        }
        if (StringUtils.isEmpty(delegate.getPhone())) {
            listenter.CreateFailed("Phone Empty");
            return;
        }
        if (StringUtils.isEmpty(delegate.getCountry())) {
            listenter.CreateFailed("Country Empty");
            return;
        }
        if (StringUtils.isEmpty(delegate.getState())) {
            listenter.CreateFailed("State Empty");
            return;
        }
        if (StringUtils.isEmpty(delegate.getDetailAddress())) {
            listenter.CreateFailed("Detail Address Empty");
            return;
        }

        doSave(delegate, listenter);
    }

    private void doSave(CreateddressDelegate delegate, final ICreateListenter listenter) {
        PostRequest request = OkGo.post(Config.ADDRESS_URL).params(getParams(delegate));
        HttpMethods.getInstance().doPost(request, true).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response response) {
                CheckError baseError = Parsing.getInstance().parsingError(response);
                if (baseError.isSuccess()) {
                    listenter.CreateSussess();
                } else {
                    listenter.CreateFailed(baseError.getBaseError().getMessage());
                }

            }
        });

    }

    @Override
    public void Modify(Address address) {

        if (!isNothingChange(delegate, address)) {
            String url = UriTemplate.fromTemplate(Config.ADDRESS_ACTION_URL)
                    .set("id", address.getId())
                    .expand();
            PutRequest request = OkGo.put(url).params(getParams(delegate));
            HttpMethods.getInstance().doPut(request, true).subscribe(new Subscriber<Response>() {
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
                        listenter.CreateSussess();
                    } else {
                        listenter.CreateFailed(checkError.getBaseError().getMessage());
                    }

                }
            });


        } else {
            listenter.CreateFailed("Nothing Is Change");
        }
    }

    private HttpParams getParams(CreateddressDelegate delegate) {
        HttpParams params = HttpMethods.getInstance().getHttpParams();
        params.put("first_name", delegate.getFirstName());
        params.put("last_name", delegate.getLastName());
        params.put("phone_number", delegate.getPhone());
        params.put("country", delegate.getCountry());
        params.put("state", delegate.getState());
        params.put("address", delegate.getDetailAddress());
        return params;

    }

    private boolean isNothingChange(CreateddressDelegate delegate, Address address) {
        boolean isChange = true;
        if (!delegate.getFirstName().equals(address.getAddress())) {
            return false;
        }
        if (!delegate.getLastName().equals(address.getLast_name())) {
            return false;
        }
        if (!delegate.getPhone().equals(address.getPhone_number())) {
            return false;
        }
        if (!delegate.getCountry().equals(address.getCountry())) {
            return false;
        }
        if (!delegate.getState().equals(address.getState())) {
            return false;
        }
        if (!delegate.getDetailAddress().equals(address.getAddress())) {
            return false;
        }
        return isChange;

    }
}
