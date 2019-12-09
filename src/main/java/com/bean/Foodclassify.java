package com.bean;


import java.util.List;

/**
 * @author 下一张幸福
 */
public class Foodclassify {

    /**
     * 食物分类id
     */
    private long fcId;
    /**
     * 食物分类名称
     */
    private String fcName;

    /**
     * 食物列表
     */
    List<Food> food;

    public long getFcId() {
        return fcId;
    }

    public void setFcId(long fcId) {
        this.fcId = fcId;
    }


    public String getFcName() {
        return fcName;
    }

    public void setFcName(String fcName) {
        this.fcName = fcName;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}
