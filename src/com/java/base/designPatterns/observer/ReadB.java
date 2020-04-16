package com.java.base.designPatterns.observer;

public class ReadB implements Observer {

    @Override
    public void update(Book object) {
        System.out.println("我是读者B,收到了新书:" + object.toString());
    }
}

