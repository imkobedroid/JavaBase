package com.java.base.lock.lockThis;

public class ThreadG extends Thread{
    private final ObjectService objectService;

    public ThreadG(ObjectService objectService){
        super();
        this.objectService=objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodG();
    }
}
