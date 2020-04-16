package com.java.base.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * 图书馆  (被观察者)
 */
public class Library extends Observable {


    private List<Book> bookList = new ArrayList<>();


    public Library() {
        Book android = new Book("android", "androidA");
        Book java = new Book("java", "javaA");
        bookList.add(android);
        bookList.add(java);
    }


    public void addBook(Book book) {
        bookList.add(book);
        super.notifyObservers(book);

    }


    public void deteleBook(Book book) {
        bookList.remove(book);
    }


}
