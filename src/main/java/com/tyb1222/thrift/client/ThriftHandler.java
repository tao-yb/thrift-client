package com.tyb1222.thrift.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ThriftHandler implements InvocationHandler {

    private Object object;


    public ThriftHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method != null){
            return method.invoke(proxy,args);
        }
        return null;
    }
}
