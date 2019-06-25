package com.java.base.designPatterns.builders.model_1;

public abstract class PersonInfo {

    String name;
    String age;
    String like;


    abstract void setLike(String like);

    abstract void setName(String name);

    abstract void setAge(String age);

    public void displayInfo(){
        System.out.print("我是"+name +"  我今年"+age+"  我喜欢"+like);
    }
}
