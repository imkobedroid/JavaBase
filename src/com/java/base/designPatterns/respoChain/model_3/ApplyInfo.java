package com.java.base.designPatterns.respoChain.model_3;

/**
 * 将申请人的操作抽象化  不需要关心是谁来申请出差费用 只关心出差申要做的事
 */
public abstract class ApplyInfo {

    int money;

    public abstract void setMoney(int money);

    public abstract int getMoney();

    public void getApply() {
        System.out.print("老大我需要的出差费用是" + getMoney());
    }

}
