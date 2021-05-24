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
 * 2021/5/19 : Create Interceptor.java
 * -----------------------------------------------------------------
 */
public interface Interceptor {
    void before(ActionInvocation invocation);

    String intercept(ActionInvocation invocation);

    void after(ActionInvocation invocation);
}
