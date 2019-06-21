package com.java.base.designPatterns.respoChain.model_2;


/**
 * 将领导需要做的事抽象成接口
 */
public interface LeaderInfo {
    void handler(ApplyInfo person);
}
