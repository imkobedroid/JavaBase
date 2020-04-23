package com.java.base.study;

import java.lang.Integer;

public class Java_7 {

    //    使用类似<? extends Number>通配符作为方法参数时表示：
//
//    方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst();；
//
//    方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n);。
//
//    即一句话总结：使用extends通配符表示可以读，不能写。
//
//    使用类似<T extends Number>定义泛型类时表示：
//
//    泛型类型限定为Number以及Number的子类。
    public static void main(String[] args) {

        PairInfo<Integer> p = new PairInfo<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }

    private static int add(PairInfo<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();


        //因为这里定义的是一个Number所以获取到的是一个Number  但是具体是哪个子类需要自己强转
        Integer integer = (Integer) p.getFirst();


//        无论是? extends Integer  或者 ? super Integer 他们的set方法只能传一个当前定义的类型的一个父类进去，因为定义属性只能定义大范围的不能定义小范围的
//        所以extends是不能进行set方法的 因为他传入的只能是子类  super可以进行set方法，因为他传入的就是一个父类，get方法与set方法相反，get只能得到一个当前定义类的具体子类，
//        所以extends能进行get方法的获取因为掺入就是一个子类，super不可以进行get方法，因为他传入的就是一个父类
//        只能set读取不能get进行设置，因为定义的泛型是? super Integer 泛型定义是Integer所以可以传一个他的父类进去设置//        p.setFirst(100);
//        p.setFirst(100d);
//        p.setFirst(100f);
//        p.setFirst(null);

        return first.intValue() + last.intValue();
    }
}

class PairInfo<T> {
    private T first;
    private T last;

    PairInfo(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}



