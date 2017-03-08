package cn.gtgs.base.OTO.activity.orders.model;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.base.model.IModel;

public class OrderData implements IModel {

    private String id;
    private String date;
    private String status;
    private String customer_id;
    private String currency;
    private boolean urgent;
    private double shipping_fee;
    private double order_total;
    private ArrayList<JSONObject> line_items;
    private Address address;


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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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

    public ArrayList<JSONObject> getLine_items() {
        return line_items;
    }

    public void setLine_items(ArrayList<JSONObject> line_items) {
        this.line_items = line_items;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "OrderData{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", currency='" + currency + '\'' +
                ", urgent='" + urgent + '\'' +
                ", shipping_fee='" + shipping_fee + '\'' +
                ", order_total='" + order_total + '\'' +
                ", line_items=" + line_items +
                ", address=" + address +
                '}';
    }
}
