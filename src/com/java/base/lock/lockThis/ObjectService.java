package com.java.base.lock.lockThis;

public class ObjectService {


    final String lock = "lock";

    public synchronized static void serviceMethodH() {
        try {
            System.out.println("F begin time=" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("F end   time=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end   time=" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        try {
            synchronized (this) {
                System.out.println("B begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("B end   time=" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodC() {
        try {
            synchronized (this) {
                System.out.println("C begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("C end   time=" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodD() {
        try {
            synchronized (lock) {
                System.out.println("D begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("D end   time=" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodE() {
        try {
            synchronized (lock) {
                System.out.println("E begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("E end   time=" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void serviceMethodF() {
        try {
            System.out.println("F begin time=" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("F end   time=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodG() {
        try {
            synchronized (ObjectService.class) {
                System.out.println("F begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("F end   time=" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
