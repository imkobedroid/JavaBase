package com.java.base.designPatterns.builders.model_2;



/**
 * 建造者的包装类
 */
public class Director {

    private String name;
    private String age;
    private String like;


    public Director(ContentBuilder contentBuilder) {
        this.name = contentBuilder.name;
        this.age = contentBuilder.age;
        this.like = contentBuilder.like;
    }


    public void displayInfo(){
        System.out.print("我是"+name +"  我今年"+age+"  我喜欢"+like);
    }



    /**
     * 由于是用Builder建造者模式来创建某个对象，因此就没有必要再定义一个Builder接口，直接提供一个具体的建造类就可以了。
     */
    public static class ContentBuilder {
        private String name;
        private String age;
        private String like;


        public ContentBuilder setName(String name) {
            this.name = name;
            return this;
        }


        public ContentBuilder setAge(String age) {
            this.age = age;
            return this;

        }


        public ContentBuilder setLike(String like) {
            this.like = like;
            return this;
        }


        public Director build() {
            return new Director(this);
        }
    }
}
