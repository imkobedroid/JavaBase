package com.java.base.designPatterns.builders.model_1;


/**
 * 具体的建造者实体类
 */
public class ContentBuilder extends Builder {

    private Person person;

    public ContentBuilder() {
        person = new Person();
    }

    @Override
    public void setName(String name) {
        person.setName(name);
    }

    @Override
    public void setAge(String age) {
        person.setAge(age);

    }

    @Override
    public void setLike(String like) {
        person.setLike(like);
    }

    @Override
    public void display() {
        person.displayInfo();
    }
}
