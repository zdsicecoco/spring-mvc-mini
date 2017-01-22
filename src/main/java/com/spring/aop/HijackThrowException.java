package com.spring.aop;

/**
 * Created by zds on 2017/1/22.
 */
import org.springframework.aop.ThrowsAdvice;

public class HijackThrowException implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("HijackThrowException : Throw exception hijacked!");
    }
}
