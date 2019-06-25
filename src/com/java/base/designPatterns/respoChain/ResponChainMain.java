package com.java.base.designPatterns.respoChain;


import com.java.base.designPatterns.respoChain.model_3.*;

/**
 * /**
 * 责任链设计模式
 * <p>
 * 一个请求沿着一条“链”传递，直到该“链”上的某个处理者处理它为止
 * 多用于一个请求可以被多个处理者处理或处理者未明确指定时。
 */
public class ResponChainMain {


    public static void main(String[] args) {

        //模拟场景1
        //领导们
//        Leader500 leader500 = new Leader500();
//        Leader1000 leader1000 = new Leader1000();
//        Leader1500 leader1500 = new Leader1500();
//        Leader2000 leader2000 = new Leader2000();
//
//        //申请人
//        Director person = new Director();
//        person.setMoney(2000);
//
//
//        if (person.getMoney() <= 500) {
//            leader500.handler(person);
//        } else if (person.getMoney() <= 1000) {
//            leader1000.handler(person);
//        } else if (person.getMoney() <= 1500) {
//            leader1500.handler(person);
//        } else if (person.getMoney() <= 2000) {
//            leader2000.handler(person);
//    }


        //模拟场景2
        //领导们
//        Leader500 leader500 = new Leader500();
//        Leader1000 leader1000 = new Leader1000();
//        Leader1500 leader1500 = new Leader1500();
//        Leader2000 leader2000 = new Leader2000();
//
//        //申请人
//        Director person = new Director();
//        person.setMoney(2000);
//
//
//        if (person.getMoney() <= 500)
//
//        {
//            leader500.handler(person);
//        } else if (person.getMoney() <= 1000)
//
//        {
//            leader1000.handler(person);
//        } else if (person.getMoney() <= 1500)
//
//        {
//            leader1500.handler(person);
//        } else if (person.getMoney() <= 2000)
//
//        {
//            leader2000.handler(person);
//        }
//
//
//    }


        //模拟场景3
        //领导们
        Leader500 leader500 = new Leader500();
        Leader1000 leader1000 = new Leader1000();
        Leader1500 leader1500 = new Leader1500();
        Leader2000 leader2000 = new Leader2000();

        leader500.setCurrentMoney(500);
        leader1000.setCurrentMoney(1000);
        leader1500.setCurrentMoney(1500);
        leader2000.setCurrentMoney(2000);

        leader500.setSuperiorLeader(leader1000);
        leader1000.setSuperiorLeader(leader1500);
        leader1500.setSuperiorLeader(leader2000);

        //申请人
        Person person = new Person();
        person.setMoney(2000);

        leader500.dealInfo(person);

    }


}



