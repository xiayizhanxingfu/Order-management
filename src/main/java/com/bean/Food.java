package com.bean;


/**
 * @author 下一张幸福
 */
public class Food {

    /**
     *编号
     */
    private long foodId;
    /**
     * 食物名称
     */
    private String foodName;
    /**
     * 食物图片地址
     */
    private String foodUrl;
    /**
     * 食物价格
     */
    private double foodPrice;
    /**
     * 食物打折后价格
     */
    private double foodDprice;
    /**
     * 食物是否可售
     */
    private long foodIsChara;
    /**
     * 食物分类
     */
    private Foodclassify foodClassify;


    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }


    public String getFoodUrl() {
        return foodUrl;
    }

    public void setFoodUrl(String foodUrl) {
        this.foodUrl = foodUrl;
    }


    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }


    public double getFoodDprice() {
        return foodDprice;
    }

    public void setFoodDprice(double foodDprice) {
        this.foodDprice = foodDprice;
    }


    public long getFoodIsChara() {
        return foodIsChara;
    }

    public void setFoodIsChara(long foodIsChara) {
        this.foodIsChara = foodIsChara;
    }


    public Foodclassify getFoodClassify() {
        return foodClassify;
    }

    public void setFoodClassify(Foodclassify foodClassify) {
        this.foodClassify = foodClassify;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", foodUrl='" + foodUrl + '\'' +
                ", foodPrice=" + foodPrice +
                ", foodDprice=" + foodDprice +
                ", foodIsChara=" + foodIsChara +
                ", foodClassify=" + foodClassify +
                '}';
    }
}
