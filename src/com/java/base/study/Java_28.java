package com.java.base.study;


//CompletableFuture

//使用Future获得异步执行结果时，要么调用阻塞方法get()，要么轮询看isDone()是否为true，这两种方法都不是很好，因为主线程也会被迫等待。
//
//        从Java 8开始引入了CompletableFuture，它针对Future做了改进，可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。

import java.util.concurrent.CompletableFuture;

//
//可见CompletableFuture的优点是：
//
//        异步任务结束时，会自动回调某个对象的方法；
//        异步任务出错时，会自动回调某个对象的方法；
//        主线程设置好回调后，不再关心异步任务的执行。


public class Java_28 {

    public static void main(String[] args) throws InterruptedException {


//        这里我们用lambda语法简化了一下，直接传入Main::fetchPrice，因为Main.fetchPrice()静态方法的签名符合Supplier接口的定义（除了方法名外）。
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Java_28::fetchPrice);
//        等价于
//        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
//            return fetchPrice();
//        });

        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);


//        如果只是实现了异步回调机制，我们还看不出CompletableFuture相比Future的优势。CompletableFuture更强大的功能是，多个CompletableFuture可以串行执行，例如，定义两个CompletableFuture，第一个CompletableFuture根据证券名称查询证券代码，第二个CompletableFuture根据证券代码查询证券价格，这两个CompletableFuture实现串行操作如下：


        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> queryCode("中国石油"));
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> fetchPrice(code));
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> System.out.println("price: " + result));
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);


//        除了串行执行外，多个CompletableFuture还可以并行执行。例如，我们考虑这样的场景：
//
//        同时从新浪和网易查询证券代码，只要任意一个返回结果，就进行下一步查询价格，查询价格也同时从新浪和网易查询，只要任意一个返回结果，就完成操作：


        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> queryCode("中国石油", "https://finance.sina.com.cn/code/"));
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> queryCode("中国石油", "https://money.163.com/code/"));

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = objectCompletableFuture.thenApplyAsync((code) -> fetchPrice((String) code, "https://finance.sina.com.cn/price/"));
        CompletableFuture<Double> cfFetchFrom163 = objectCompletableFuture.thenApplyAsync((code) -> fetchPrice((String) code, "https://money.163.com/price/"));

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> objectCompletableFuture1 = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        objectCompletableFuture1.thenAccept((result) -> System.out.println("price: " + result));
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);

    }


    private static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }


    private static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        return "601857";
    }

    private static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        return 5 + Math.random() * 20;
    }


    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException ignored) {
        }
        return 5 + Math.random() * 20;
    }

}
