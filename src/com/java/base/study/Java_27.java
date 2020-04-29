package com.java.base.study;


//Future使用

//Runnable接口有个问题，它的方法没有返回值。如果任务需要一个返回结果，那么只能保存到变量，还要提供额外的方法读取，非常不便。所以，Java标准库还提供了一个Callable接口，和Runnable接口比，它多了一个返回值：


import java.util.concurrent.*;

public class Java_27 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
// 定义任务:
        Callable<String> task = new TaskInfo();
// 提交任务并获得Future:
        Future<String> future = executor.submit(task);

// 从Future获取异步执行返回的结果:
//        在调用get()时，如果异步任务已经完成，我们就直接获得结果。如果异步任务还没有完成，那么get()会阻塞，直到任务完成后才返回结果。
        String result = future.get();

        System.out.println(result);

    }
}


class TaskInfo implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(3000);   //验证阻塞的情况
        return "kobe";
    }
}

