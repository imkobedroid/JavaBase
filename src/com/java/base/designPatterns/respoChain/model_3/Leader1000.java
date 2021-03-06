package com.java.base.designPatterns.respoChain.model_3;


/**
 * 申请1000已下的金额可以批，大于1000会向上级回报
 */
public class Leader1000 extends LeaderInfo {


    @Override
    public void setCurrentMoney(int money) {
        super.auditMoney = money;
    }

    @Override
    public void handler(ApplyInfo applyInfo) {
        applyInfo.getApply();
        System.out.print("     我是Leader1000  你需要申请的" + applyInfo.getMoney() + "我批准了");

    }

    @Override
    public void setSuperiorLeader(LeaderInfo superiorLeader) {
        super.superiorLeader = superiorLeader;
    }
}
