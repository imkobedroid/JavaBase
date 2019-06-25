package com.java.base.designPatterns.respoChain.model_1;


/**
 * 员工A要出差
 */
public class Person {

    private int money;


    /**
     * 设置出差需要非费用
     */
    public void setMoney(int money) {
        this.money = money;
    }


    /**
     * 获取需要申请的出差费用
     */
    public int getMoney() {
        return money;
    }


    /**
     * 向上级回报
     */
    public void getApply() {
        System.out.print("老大我需要的出差费用是" + getMoney());
    }

}
