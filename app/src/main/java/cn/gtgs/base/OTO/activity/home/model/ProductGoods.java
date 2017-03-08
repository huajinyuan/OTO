package cn.gtgs.base.OTO.activity.home.model;

import java.io.Serializable;
import java.util.ArrayList;

import cn.gtgs.base.OTO.base.model.IModel;

/**
 * Created by gtgs on 2017/3/6.
 */

public class ProductGoods implements IModel, Serializable {
    private String id;
    private String name;
    private String description;
    private String price;
    private String sku;
    private String type;
    private ArrayList<Attribute> attributes;
    private String simple_attrs;
    private String categories;
    private String tags;
    private ArrayList<ProductImage> images;
    private ArrayList<Variations> variations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getSimple_attrs() {
        return simple_attrs;
    }

    public void setSimple_attrs(String simple_attrs) {
        this.simple_attrs = simple_attrs;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public ArrayList<ProductImage> getImages() {
        return images;
    }

    public void setImages(ArrayList<ProductImage> images) {
        this.images = images;
    }

    public ArrayList<Variations> getVariations() {
        return variations;
    }

    public void setVariations(ArrayList<Variations> variations) {
        this.variations = variations;
    }

    @Override
    public String toString() {
        return "ProductGoods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", sku='" + sku + '\'' +
                ", type='" + type + '\'' +
                ", attributes=" + attributes +
                ", simple_attrs='" + simple_attrs + '\'' +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                ", images=" + images +
                ", variations=" + variations +
                '}';
    }
}
