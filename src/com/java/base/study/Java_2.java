package com.java.base.study;


//反射

//
//        Field getField(name)：根据字段名获取某个public的field（包括父类）
//        Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
//        Field[]getFields()：获取所有public的field（包括父类）
//        Field[]getDeclaredFields()：获取当前类的所有field（不包括父类）


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Java_2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class aClass = Student.class;
        System.out.println(aClass.getField("score"));
        System.out.println(aClass.getField("name"));
        System.out.println(aClass.getDeclaredField("grade"));


        System.out.println(aClass.getDeclaredField("grade").getName());
        System.out.println(aClass.getDeclaredField("grade").getType());
        System.out.println(aClass.getDeclaredField("grade").getModifiers());


        int m = aClass.getDeclaredField("grade").getModifiers();

        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isProtected(m));
        System.out.println(Modifier.isPrivate(m));
        System.out.println(Modifier.isStatic(m));


        Object test = new Test("kobe");
        Class cls = test.getClass();
        Field f = cls.getDeclaredField("name");
        f.setAccessible(true);  //别管这个字段是不是public，一律允许访问。
        Object value = f.get(test);
        System.out.println(value);
        f.set(test,"张三");
        System.out.println(((Test)test).getName()); // "Xiao Hong"


    }

}


class Student extends Person {
    public int score;
    private int grade;
}

class Person {
    public String name;
}


class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}