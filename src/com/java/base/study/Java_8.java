package com.java.base.study;

import java.lang.Integer;
import java.util.List;

public class Java_8 {


//    使用场景：
//    即：如果需要返回T，它是生产者（Producer），要使用extends通配符；如果需要写入T，它是消费者（Consumer），要使用super通配符。


    public static void main(String[] args) {

//        使用<? super Integer>通配符表示：
//
//        允许调用set(? super Integer)方法传入Integer的引用；
//
//        不允许调用get()方法获得Integer的引用。
//        唯一例外是可以获取Object的引用：Object o = p.getFirst()。


//        我们再回顾一下extends通配符。作为方法参数，<? extends T>类型和<? super T>类型的区别在于：
//
//<? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
//
//<? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
//
//        一个是允许读不允许写，另一个是允许写不允许读。


        PairInfoType<Number> p1 = new PairInfoType<>(12.3, 4.56);
        PairInfoType<Integer> p2 = new PairInfoType<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }


    private static void setSame(PairInfoType<? super Integer> type, Integer n) {

//        无论是? extends Integer  或者 ? super Integer 他们的set方法只能传一个当前定义的类型的一个父类进去，因为定义属性只能定义大范围的不能定义小范围的
//        所以extends是不能进行set方法的 因为他传入的只能是子类  super可以进行set方法，因为他传入的就是一个父类，get方法与set方法相反，get只能得到一个当前定义类的具体子类，
//        所以extends能进行get方法的获取因为掺入就是一个子类，super不可以进行get方法，因为他传入的就是一个父类
//        只能set读取不能get进行设置，因为定义的泛型是? super Integer 泛型定义是Integer所以可以传一个他的父类进去设置
        type.setFirst(n);
        type.setLast(n);

        Number number = (Number) type.getFirst();
    }
}


class PairInfoType<T> {
    private T first;
    private T last;

    PairInfoType(T first, T last) {
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


//    我们来看Java标准库的Collections类定义的copy()方法：  这个copy()方法的定义就完美地展示了extends和super的意图：

//    copy()方法内部不会读取dest，因为不能调用dest.get()来获取T的引用；

//    copy()方法内部也不会修改src，因为不能调用src.add(T)。
class Collections {
    // 把src的每个元素复制到dest中:
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            T t = src.get(i);
            dest.add(t);
        }
    }
}