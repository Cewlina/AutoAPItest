package com.course.testng;

import org.testng.annotations.Test;

/**
 * 异常测试用于：当我们期望结果为某一个异常的情况
 * 比如：我们传入了不合法的参数，期望程序抛出异常
 * 预期结果就是这个异常
 */
public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }
}
