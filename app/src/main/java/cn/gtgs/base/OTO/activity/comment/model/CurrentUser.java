package cn.gtgs.base.OTO.activity.comment.model;

import java.io.Serializable;

import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.base.model.BaseError;

/**
 * Created by gtgs on 2017/3/7.
 */

public class CurrentUser extends BaseError implements Serializable {
    private String id;
    private String email;
    private String username;
    private String phone_number;
    private String sex;
    private String user_url;
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUser_url() {
        return user_url;
    }

    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", sex='" + sex + '\'' +
                ", user_url='" + user_url + '\'' +
                ", address=" + address +
                '}';
    }
}
