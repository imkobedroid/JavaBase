package com.java.base.lock.lockThis;

public class ThreadE extends Thread{
    private final ObjectService objectService;

    public ThreadE(ObjectService objectService){
        super();
        this.objectService=objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodE();
    }
}
