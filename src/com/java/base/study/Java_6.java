package com.java.base.study;

import java.lang.Integer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Java_6 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {


//        List<String> list = new ArrayList<>();
//        list.add("kobe");
//        System.out.println(list.size() + "");
//
//
//        List<Number> numbers = new ArrayList<>();
//        numbers.add(1d);
//        numbers.add(1.4566f);
//        numbers.add(1);
//        for (Number number : numbers) {
//            System.out.println(number);
//        }

//        Pair<PersonInfo> pair = new Pair<>(PersonInfo.class);
//        pair.getFirst().setName("kobe");
//        pair.getFirst().setAge("40");
//
//        pair.getLast().setName("zhangsan");
//        pair.getLast().setAge("50");
//
//        System.out.println(pair.getFirst().getName());
//        System.out.println(pair.getFirst().getAge());
//        System.out.println(pair.getLast().getName());
//        System.out.println(pair.getLast().getAge());


//        例如：IntPair可以获取到父类的泛型类型Integer。获取父类的泛型类型代码比较复杂：
        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }

    }
}


//class PersonInfo<T> {
//    private T name;
//    private T age;
//
//
//    public T getName() {
//        return name;
//    }
//
//    public void setName(T name) {
//        this.name = name;
//    }
//
//    public T getAge() {
//        return age;
//    }
//
//    public void setAge(T age) {
//        this.age = age;
//    }
//}
//
//
//class Pair<T> {
//    private T first;
//    private T last;
//
//
//    //    newInstance()也是用来创建新的对象,其与new()的区别是:
//    //    newInstance():弱类型,效率低,只能调用无参构造
//    //    new():强类型,高效率,能调用任何public构造器
//    Pair(Class<T> aClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        first = aClass.getDeclaredConstructor().newInstance();
//        last = aClass.getDeclaredConstructor().newInstance();
//    }
//
//
//    public T getFirst() {
//        return first;
//    }
//
//    public T getLast() {
//        return last;
//    }
//
//    public void setFirst(T first) {
//        this.first = first;
//    }
//
//    public void setLast(T last) {
//        this.last = last;
//    }
//}


class Pair<T> {
    private T first;
    private T last;

    Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}

class IntPair extends Pair<Integer> {
    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}