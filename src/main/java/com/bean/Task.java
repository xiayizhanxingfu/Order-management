package com.bean;


/**
 * @author 下一张幸福
 */
public class Task {

    /**
     * 任务编号
     */
    private long taskId;
    /**
     * 任务状态,0:等待领取;1:己领取,正在做;2:完成任务
     */
    private long status;
    /**
     * 任务负责人员
     */
    private String functionary;
    /**
     * 食物数量
     */
    private long size;
    /**
     * 订单信息
     */
    private Orderform orderform;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


    public String getFunctionary() {
        return functionary;
    }

    public void setFunctionary(String functionary) {
        this.functionary = functionary;
    }



    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }


    public Orderform getOrderform() {
        return orderform;
    }

    public void setOrderform(Orderform orderform) {
        this.orderform = orderform;
    }
}
