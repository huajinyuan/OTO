package cn.gtgs.base.OTO.activity.ShopCar.model;

import cn.gtgs.base.OTO.base.model.IModel;

/**
 * Created by gtgs on 2017/2/22.
 */

public class ShopCarGoods implements IModel {
    private boolean isChoose = false;
    private int product_id;
    private double price;
    private String name;
    private int qty = 1;

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ShopCarGoods{" +
                "isChoose=" + isChoose +
                ", product_id=" + product_id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}
