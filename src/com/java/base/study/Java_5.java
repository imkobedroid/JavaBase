package com.java.base.study;


import java.lang.annotation.*;
import java.lang.reflect.Field;


//判断某个注解是否存在于Class、Field、Method或Constructor：
//
//        Class.isAnnotationPresent(Class)
//        Field.isAnnotationPresent(Class)
//        Method.isAnnotationPresent(Class)
//        Constructor.isAnnotationPresent(Class)


@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
    int max() default 255;

    int min() default 10;
}


//最常用的元注解是@Target。使用@Target可以定义Annotation能够被应用于源码的哪些位置：
//
//        类或接口：ElementType.TYPE；
//        字段：ElementType.FIELD；
//        方法：ElementType.METHOD；
//        构造方法：ElementType.CONSTRUCTOR；
//        方法参数：ElementType.PARAMETER


//仅编译期：RetentionPolicy.SOURCE；
//        仅class文件：RetentionPolicy.CLASS；
//        运行期：RetentionPolicy.RUNTIME。


//在使用的时候，如果一个类用到了@Report：
//@Inherited
//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
//@interface Report {
//
//    int type() default 0;
//
//    String level() default "info";
//
//    String value() default "";
//}


//@Inherited
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.PARAMETER)
//@interface Range {
//    int max() default 0;
//}
//
//
//@Inherited
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.PARAMETER)
//@interface NotNull {
//}

//@Report(value = "kobe", type = 1, level = "ok")
public class Java_5 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {

//        // 判断@Report是否存在于Person类:
//        System.out.println(Java_5.class.isAnnotationPresent(Report.class));
//
//
//        // 获取Person定义的@Report注解:
//        Report report = Java_5.class.getAnnotation(Report.class);
//        int type = report.type();
//        String level = report.level();
//        String value = report.value();
//
//        System.out.println(type + "  " + level + "   " + value);


        //获取值的方法一

//        if (Java_5.class.isAnnotationPresent(Report.class)) {
//            Report report = Java_5.class.getAnnotation(Report.class);
//            int type = report.type();
//            String level = report.level();
//            String value = report.value();
//            System.out.println(type + "  " + level + "   " + value);
//
//        }
//
//        //获取值的方法二
//        Report report = Java_5.class.getAnnotation(Report.class);
//        if (report != null) {
//            int type = report.type();
//            String level = report.level();
//            String value = report.value();
//            System.out.println(type + "  " + level + "   " + value);
//        }


//        //获取方法注解
//        Method m = Java_5.class.getMethod("initTest", String.class, String.class);
//        Annotation[][] annos = m.getParameterAnnotations();
//        // 第一个参数（索引为0）的所有Annotation:
//        Annotation[] annosOfName = annos[0];
//        for (Annotation annotation : annosOfName) {
//            if (annotation instanceof Range) { // @Range注解
//                Range r = (Range) annotation;
//                System.out.println("反射获取到的值是:" + r.max());
//            }
//            if (annotation instanceof NotNull) { // @NotNull注解
//                NotNull n = (NotNull) annotation;
//            }
//        }


        Info info = new Info();
        info.city = "chengdufsdfsff";
        info.name = "fdsf";
        Field[] fields = info.getClass().getFields();
        for (Field field : fields) {
            Range annotation = field.getAnnotation(Range.class);
            if (annotation != null) {
                Object object = field.get(info);
                if (object instanceof String) {
                    String s = (String) object;
                    if (s.length() < annotation.min() || s.length() > annotation.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
//
//
//    @Report(value = "kobe", type = 1, level = "ok")
//    public void init() {
//    }
//
//
//    public void initTest(@NotNull @Range(max = 5) String name, @NotNull String prefix) {
//
//    }
}

class Info {

    @Range(max = 200, min = 11)
    public String name;

    @Range(max = 9)
    public String city;
}
