package com.java.base.study;

/*如何正确编写equals()方法？equals()方法要求我们必须满足以下条件：

        自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
        对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
        传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
        一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
        对null的比较：即x.equals(null)永远返回false。*/


import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Java_9 {


    public static void main(String[] args) {

        List<PersonInfo> personInfos = List.of(
                new PersonInfo("kobe", 40),
                new PersonInfo("zhangsan", 30)
        );

        System.out.println(new PersonInfo("kobe", 40).equals(personInfos.get(0)));




        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
    }
}

class PersonInfo {

    private String name;
    private int age;

    PersonInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PersonInfo) {
            PersonInfo person = (PersonInfo) obj;
            return Objects.equals(this.name, person.name) && this.age == person.age;

        }
        return false;
    }
}
