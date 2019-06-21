package com.java.base.designPatterns.respoChain.model_2;



/**
 * 申请1500已下的金额可以批，大于1500会向上级回报
 */
public class Leader1500   implements LeaderInfo {
    @Override
    public void handler(ApplyInfo person) {
        person.getApply();
        System.out.print("     我是Leader1500  你需要申请的" + person.getMoney() + "我批准了");

    }
}
