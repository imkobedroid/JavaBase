package com.java.base.lock.lockThis;

public class ThreadA  extends Thread{
    private final ObjectService objectService;

    public ThreadA(ObjectService objectService){
        super();
        this.objectService=objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodA();
    }
}
