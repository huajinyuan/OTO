package cn.gtgs.base.OTO.activity.home.model;

import java.io.Serializable;
import java.util.Arrays;

import cn.gtgs.base.OTO.base.model.IModel;

/**
 * Created by gtgs on 2017/3/8.
 */

public class Attribute implements Serializable, IModel {
    private String name;
    private String position;
    private String[] options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }
}
