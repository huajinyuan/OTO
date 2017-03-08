package cn.gtgs.base.OTO.activity.Address.presenter;

import cn.gtgs.base.OTO.activity.Address.model.Address;

/**
 * Created by gtgs on 2017/2/10.
 */

public interface ICreateAddressPresenter {
    void initData(Address address);

    void saveAddress();

    void Modify(Address address);
}
