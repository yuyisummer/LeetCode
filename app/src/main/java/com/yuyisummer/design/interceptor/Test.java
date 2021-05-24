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
 * 2021/5/19 : Create Test.java
 * -----------------------------------------------------------------
 */
class Test {
    public static void test3() {
        Interceptor exptionInterceptor = new ExceptionInterceptor();
        Interceptor i18nInterceptor = new I18NInterceptor();
        Interceptor aroundInterceptor = new AroundInterceptor();

        DefaultActionInvoation actionInvocation = new DefaultActionInvoation();
        actionInvocation.addInterceptor(exptionInterceptor);
        actionInvocation.addInterceptor(i18nInterceptor);
        actionInvocation.addInterceptor(aroundInterceptor);


        Action action = new HelloWorldAction();
        actionInvocation.setAction(action);

        String result = actionInvocation.invoke();
        System.out.println("Action result:" + result);
    }
}
