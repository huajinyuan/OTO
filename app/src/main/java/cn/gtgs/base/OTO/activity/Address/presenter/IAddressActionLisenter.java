package cn.gtgs.base.OTO.activity.Address.presenter;

import java.util.ArrayList;

import cn.gtgs.base.OTO.activity.Address.model.Address;

/**
 * Created by gtgs on 2017/2/22.
 */

public interface IAddressActionLisenter {
    void change(ArrayList<Address> mDatas);

    void deleteItem(Address address);

    void modifyItem(Address address);

    void doActionSussese();

    void doActionFailed(String msg);
}
