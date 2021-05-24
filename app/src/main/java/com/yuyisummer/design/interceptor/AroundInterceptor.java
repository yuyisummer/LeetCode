package com.yuyisummer.design.interceptor;

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2011-2021, by your Signway, All rights reserved.
 * -----------------------------------------------------------------
 *
 * ProjectName: LeedCode
 *
 * Author: yuyisummer
 *
 * Email: jh.yu@Signway.cn
 *
 * Description:
 *
 * -----------------------------------------------------------------
 * 2021/5/19 : Create AroundInterceptor.java
 * -----------------------------------------------------------------
 */
public class AroundInterceptor implements Interceptor {

    @Override
    public void before(ActionInvocation invocation) {
        // TODO Auto-generated method stub
        System.out.println("before:" + "AroundInterceptor");
    }

    @Override
    public String intercept(ActionInvocation invocation) {
        // TODO Auto-generated method stub
        before(invocation);
        String result = invocation.invoke();
        after(invocation);
        return result;
    }

    @Override
    public void after(ActionInvocation invocation) {
        // TODO Auto-generated method stub
        System.out.println("after:" + "AroundInterceptor");
    }
}