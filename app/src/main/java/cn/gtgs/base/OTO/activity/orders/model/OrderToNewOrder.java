package cn.gtgs.base.OTO.activity.orders.model;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * Created by gtgs on 2017/3/7.
 */

public class OrderToNewOrder {
    private static OrderToNewOrder orderUtils;

    public static OrderToNewOrder getInstance() {
        if (null == orderUtils) {
            orderUtils = new OrderToNewOrder();
        }
        return orderUtils;
    }

    public ArrayList<NewOrderData> OrderListTNew(ArrayList<OrderData> data) {
        ArrayList<NewOrderData> datas = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            OrderData orderData = data.get(i);
            ArrayList<NewOrderData> da = OrderToNew(orderData);
            datas.addAll(da);
        }
        return datas;
    }

    public ArrayList<NewOrderData> OrderToNew(OrderData orderData) {
        ArrayList<NewOrderData> datas = new ArrayList<>();
        datas.add(new NewOrderData(1, orderData.getId(), orderData.getDate()));
        ArrayList<JSONObject> obs = orderData.getLine_items();
        for (int j = 0; j < obs.size(); j++) {
            NewOrderData newDate = new NewOrderData(orderData.getId(), orderData.getStatus(), obs.get(j));
            if (j == 0) {
                newDate.setType(4);
            } else {
                newDate.setType(8);
            }
            datas.add(newDate);
        }
        datas.add(new NewOrderData(2, orderData.getId(), orderData.isUrgent(), orderData.getShipping_fee(), orderData.getOrder_total(), orderData.getCurrency()));
        return datas;
    }
}
