package com.java.base.study;


//队列（Queue）是一种经常使用的集合。Queue实际上是实现了一个先进先出（FIFO：First In First Out）的有序表。它和List的区别在于，List可以在任意位置添加和删除元素，而Queue只有两个操作：
//
//        把元素添加到队列末尾；
//        从队列头部取出元素。


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//int size()：获取队列长度；
//        boolean add(E)/boolean offer(E)：添加元素到队尾；
//        E remove()/E poll()：获取队首元素并从队列中删除；
//        E element()/E peek()：获取队首元素但并不从队列中删除
public class Java_11 {

    public static void main(String[] args) {

//        Queue<String> stringQueue=new LinkedList<>();
//        stringQueue.offer("1");
//        stringQueue.offer("2");
//        stringQueue.offer("3");
//
//        System.out.println(stringQueue.poll());
//        System.out.println(stringQueue.poll());
//        System.out.println(stringQueue.poll());

//        Queue<String> queue = new LinkedList<>();
//        queue.offer("1");
//        queue.offer("2");
//        queue.offer("3");
//
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//
//
//        // 这是一个List:
//        List<String> list = new LinkedList<>();
//        // 这是一个Queue:
//        Queue<String> queue1 = new LinkedList<>();
//

//        PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。
//
//        Queue<String> q = new PriorityQueue<>();
//        q.offer("apple");
//        q.offer("pear");
//        q.offer("banana");
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());

//        我们放入的顺序是"apple"、"pear"、"banana"，但是取出的顺序却是"apple"、"banana"、"pear"，这是因为从字符串的排序看，"apple"排在最前面，"pear"排在最后面。
//
//        因此，放入PriorityQueue的元素，必须实现Comparable接口，PriorityQueue会根据元素的排序顺序决定出队的优先级。
//
//        如果我们要放入的元素并没有实现Comparable接口怎么办？PriorityQueue允许我们提供一个Comparator对象来判断两个元素的顺序。我们以银行排队业务为例，实现一个PriorityQueue：




        Queue<User> users = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        users.offer(new User("Bob", "A1"));
        users.offer(new User("Alice", "A2"));
        users.offer(new User("Boss", "V1"));
        System.out.println(users.poll()); // Boss/V1
        System.out.println(users.poll()); // Bob/A1
        System.out.println(users.poll()); // Alice/A2
        System.out.println(users.poll()); // null,因为队列为空
    }


}


class UserComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            return u1.number.compareTo(u2.number);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}


class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}