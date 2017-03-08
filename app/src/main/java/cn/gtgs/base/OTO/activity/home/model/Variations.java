package cn.gtgs.base.OTO.activity.home.model;

import java.io.Serializable;

import cn.gtgs.base.OTO.base.model.IModel;

/**
 * Created by gtgs on 2017/3/8.
 */

public class Variations implements Serializable, IModel {
    private String id;
    private String price;
    private String sku;
    private String images;
    private String attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Variations{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", sku='" + sku + '\'' +
                ", images='" + images + '\'' +
                ", attributes='" + attributes + '\'' +
                '}';
    }
}
