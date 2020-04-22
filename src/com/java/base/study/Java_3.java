package com.java.base.study;

//
//        Method getMethod(name, Class...)：获取某个public的Method（包括父类）
//        Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
//        Method[] getMethods()：获取所有public的Method（包括父类）
//        Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）


//        getName()：返回方法名称，例如："getScore"；
//        getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
//        getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
//        getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射  调用方法
public class Java_3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//
//        Class<Student3> aClass = Student3.class;
//        // 获取public方法getScore，参数为String:
//        System.out.println(aClass.getMethod("getScore", String.class));
//
//        System.out.println(aClass.getMethod("getName"));
//        // 获取private方法getGrade，参数为int:
//        System.out.println(aClass.getDeclaredMethod("getGrade", int.class));


//        String s = "Hello world";
//        String r = s.substring(6); // "world"
//        用反射完成上面截取字符串功能

//        String s = "hello world";
//        Method method = String.class.getMethod("substring", int.class);
//        Object str = method.invoke(s, 6);
//        System.out.println(str);


//        如果获取到的Method表示一个静态方法，调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null。我们以Integer.parseInt(String)为例：
//        Method m = Integer.class.getMethod("parseInt", String.class);
//        // 调用该静态方法并获取结果:
//        Integer n = (Integer) m.invoke(null, "12345");
//        // 打印调用结果:
//        System.out.println(n);


        Person2 p = new Person2();
        Method m = p.getClass().getDeclaredMethod("setName", String.class);
        m.setAccessible(true);
        m.invoke(p, "Bob");
        System.out.println(p.name);
    }

}



class Person2 {
    String name;
    private void setName(String name) {
        this.name = name;
    }
}


class Person3 {
    public String getName() {
        return "Person";
    }
}


class Student3 extends Person3 {
    public int getScore(String type) {
        return 99;
    }

    private int getGrade(int year) {
        return 1;
    }
}

