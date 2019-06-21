package com.java.base.designPatterns.respoChain.model_1;


/**
 * 申请1500已下的金额可以批，大于1500会向上级回报
 */
public class Leader1500 {

    public void handler(Person person) {

        person.getApply();
        System.out.print("     我是Leader1500  你需要申请的" + person.getMoney() + "我批准了");
    }

}
