package com.java.base.designPatterns.observer;

public class ReadA implements Observer {


    @Override
    public void update(Book object) {
        System.out.println("我是读者A,收到了新书:"+object.toString());
    }
}
