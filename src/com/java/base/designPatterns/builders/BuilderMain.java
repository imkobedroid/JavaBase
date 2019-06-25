package com.java.base.designPatterns.builders;

import com.java.base.designPatterns.builders.model_1.ContentBuilder;
import com.java.base.designPatterns.builders.model_1.Director;

public class BuilderMain {


    public static void main(String[] args) {

        ContentBuilder contentBuilder = new ContentBuilder();
        contentBuilder.setAge("40");
        contentBuilder.setName("kobe");
        contentBuilder.setLike("打篮球");

        Director director = new Director(contentBuilder);
        director.display();

    }

}
