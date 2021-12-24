package com.java.base.lock.lockThis;

public class ThreadF extends Thread{
    private final ObjectService objectService;

    public ThreadF(ObjectService objectService){
        super();
        this.objectService=objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodF();
    }
}
