package com.java.base.designPatterns.respoChain.model_2;


/**
 * 申请人
 */
public class Person extends ApplyInfo {

    @Override
    public void setMoney(int money) {
        super.money = money;
    }

    @Override
    public int getMoney() {
        return super.money;
    }
}
