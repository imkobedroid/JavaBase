package com.java.base.designPatterns.observer;


import java.util.Vector;

public abstract class Observable {


    /**
     * 观察者的集合
     */
    private Vector<Observer> vector = new Vector<>();


    /**
     * 增加一个gua观察者
     */
    public void addObserver(Observer observer) {
        vector.add(observer);
    }


    /**
     * 删除一个观察者
     */
    public void deleteObserver(Observer observer) {
        vector.remove(observer);
    }


    /**
     * 通知观察者
     */
    public void notifyObservers(Book book) {

        for (Observer observer : vector) {
            observer.update(book);
        }

    }

}
