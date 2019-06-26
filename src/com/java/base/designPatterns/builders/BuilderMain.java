package com.java.base.designPatterns.builders;


import com.java.base.designPatterns.builders.model_2.Director;

public class BuilderMain {


    public static void main(String[] args) {
//
//        ContentBuilder contentBuilder = new ContentBuilder();
//        contentBuilder.setAge("40");
//        contentBuilder.setName("kobe");
//        contentBuilder.setLike("打篮球");
//
//        Director director = new Director(contentBuilder);
//        director.display();
//



        Director director = new Director.ContentBuilder()
                .setAge("40")
                .setName("kobe")
                .setLike("篮球")
                .build();
        director.displayInfo();

    }

}
