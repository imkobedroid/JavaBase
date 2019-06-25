package com.java.base.designPatterns.builders.model_1;


/**
 * 具体的外层实体类
 */
public class Director {


    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void display(){
        builder.display();
    }

}
