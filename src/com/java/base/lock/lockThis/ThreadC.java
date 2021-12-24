package com.java.base.lock.lockThis;

public class ThreadC extends Thread{
    private final ObjectService objectService;

    public ThreadC(ObjectService objectService){
        super();
        this.objectService=objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodC();
    }
}
