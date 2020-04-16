package com.java.base.study;


//psvm   main的快捷键
//souf   print的快捷键


enum Key {
    MON, TUE, WED, THU, FRI, SAT, SUN;

}


enum Weekday {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

    public final int dayValue;

    private Weekday(int dayValue) {
        this.dayValue = dayValue;
    }
}


enum Weekday1 {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday1(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}

//StringJoiner
public class Java_1 {

//    public static void main(String[] args) {
//        String[] names = {"kobe", "zhangsan", "lisi"};
//        StringJoiner stringJoiner = new StringJoiner(",");
//        for (int i = 0; i < names.length; i++) {
//            stringJoiner.add(names[i]);
//        }
//        System.out.print(stringJoiner.toString());
//    }


//    public static void main(String[] args) {
//        String[] names = {"kobe", "zhangsan", "lisi"};
//        StringJoiner stringJoiner = new StringJoiner(", ", "Hello ", "!");
//        for (String name : names) {
//            stringJoiner.add(name);
//        }
//        System.out.print(stringJoiner.toString());
//    }


//    public static void main(String[] args) {
//        String[] names = {"kobe", "zhangsan", "lisi"};
//        String s = String.join(",", names);
//        System.out.print(s);
//    }


//    public static void main(String[] args) {
//        Integer integer = new Integer(99);
//        int n3 = integer.getValue();
//        System.out.print(String.valueOf(n3));
//    }


    public static void main(String[] args) {
//        System.out.print(Key.FRI.name());

//        Weekday day = Weekday.SUN;
//        if (day.dayValue == 6 || day.dayValue == 0) {
//            System.out.println("Work at home!");
//        } else {
//            System.out.println("Work at office!");
//        }

        Weekday1 day = Weekday1.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day + ". Work at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }

    }
}

class Integer {

    int value;

    public Integer(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}