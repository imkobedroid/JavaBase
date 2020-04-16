package com.java.base.designPatterns.observer;

public class Book {


    private String bookName;
    private String author;



    public Book(String bookName,String author){
        this.bookName=bookName;
        this.author=author;
    }

    public String getBookName(){
        return bookName;
    }

    public void setBookName(String name){
        bookName=name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String anthor){
        this.author=author;

    }
}
