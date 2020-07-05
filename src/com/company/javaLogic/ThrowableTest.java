package com.company.javaLogic;

import java.util.concurrent.ConcurrentHashMap;

public class ThrowableTest {
    public static void main(String[] args) {
        try {
            throw new ExceptionTest("data");
        } catch (ExceptionTest exceptionTest) {
            exceptionTest.printStackTrace();
        }
    }
}

class ExceptionTest extends Throwable {
    public ExceptionTest(String msg) {
        super(msg);
    }
}