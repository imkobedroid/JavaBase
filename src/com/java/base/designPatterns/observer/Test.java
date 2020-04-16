package com.java.base.designPatterns.observer;

public class Test {

    public static void main(String[] args) {

        Library library=new Library();

        ReadA readA=new ReadA();
        ReadB readB=new ReadB();


        library.addObserver(readA);
        library.addObserver(readB);

        library.addBook(new Book("python","pythonA"));

    }
}
