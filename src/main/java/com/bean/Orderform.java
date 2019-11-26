package com.bean;


/**
 * @author 下一张幸福
 */
public class Orderform {

    /**
     * 编号
     */
    private long orderId;
    /**
     * 用户信息
     */
    private Users users;
    /**
     * 食物
     */
    private Food food;
    /**
     * 客户位置
     */

    private String location;
    /**
     * 数量
     */
    private long size;
    /**
     * 订单状态,0:未付款,1:付款,2未上菜,3:交易完成
     */
    private long status;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

}
