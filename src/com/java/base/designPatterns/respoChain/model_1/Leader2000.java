package com.java.base.designPatterns.respoChain.model_1;


/**
 * 申请2000已下的金额可以批，大于2000会向上级回报
 */
public class Leader2000 {

    public void handler(Person person) {

        person.getApply();
        System.out.print("     我是Leader2000  你需要申请的" + person.getMoney() + "我批准了");
    }

}
