package cn.gtgs.base.OTO.activity.home.model;

/**
 * Created by gtgs on 2017/3/8.
 */

public class ProductImage {
    private String id;
    private String position;
    private String src;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id='" + id + '\'' +
                ", position='" + position + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
