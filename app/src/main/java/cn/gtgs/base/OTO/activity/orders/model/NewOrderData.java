package cn.gtgs.base.OTO.activity.orders.model;


import com.alibaba.fastjson.JSONObject;

import cn.gtgs.base.OTO.base.model.IModel;

public class NewOrderData implements IModel {
    private int type;//1：头部 2：底部 4：order第一行 8：order非第一行
    private String id;
    private String date;
    private String status;
    private String currency;
    private boolean urgent;
    private double shipping_fee;
    private double order_total;
    private JSONObject product;

    public NewOrderData(int type, String id, String date) {
        this.type = type;
        this.id = id;
        this.date = date;
    }

    public NewOrderData(String id, String status, JSONObject product) {
        this.id = id;
        this.status = status;
        this.product = product;
    }

    public NewOrderData(int type, String id, boolean urgent, double shipping_fee, double order_total, String currency) {
        this.type = type;
        this.id = id;
        this.urgent = urgent;
        this.shipping_fee = shipping_fee;
        this.order_total = order_total;
        this.currency = currency;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public double getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(double shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }

    public JSONObject getProduct() {
        return product;
    }

    public void setProduct(JSONObject product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "NewOrderData{" +
                "type=" + type +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", currency='" + currency + '\'' +
                ", urgent=" + urgent +
                ", shipping_fee=" + shipping_fee +
                ", order_total=" + order_total +
                ", product=" + product +
                '}';
    }
}
