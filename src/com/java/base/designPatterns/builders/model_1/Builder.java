package com.java.base.designPatterns.builders.model_1;


/**
 * 构建建造工厂的抽象类，因为一般会涉及到一些属性，所以这里一般是做成抽象类而不是接口
 * <p>
 * <p>
 * 我们定义了两个简单的方法方便展示
 */
public abstract class Builder {

    public abstract void setName(String name);

    public abstract void setAge(String age);

    public abstract void setLike(String like);

    public abstract void display();

}
