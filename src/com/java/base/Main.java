package com.java.base;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("小明", 10);
        Person person2 = new Person("小张", 20);


//        if (person1.equals(person2)) {
//            System.out.print("小明其实就是小张");
//        } else {
//            System.out.print("他们是两个人");
//        }

//        int hash1=person1.hashCode();
//        int hash2=person2.hashCode();
//
//
//        if (hash1==hash2) {
//            System.out.print("小明其实就是小张");
//        } else {
//            System.out.print("他们是两个人");
//        }

        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = s1+s2;
        System.out.println(s3==s4);
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
    }
}


