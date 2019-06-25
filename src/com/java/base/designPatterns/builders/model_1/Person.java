package com.java.base.designPatterns.builders.model_1;

public class Person extends PersonInfo {


    @Override
    void setLike(String like) {
        super.like = like;
    }

    @Override
    void setName(String name) {
        super.name = name;

    }

    @Override
    void setAge(String age) {
        super.age = age;
    }
}
