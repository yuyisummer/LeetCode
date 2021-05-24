package com.yuyisummer.design.interceptor;

import java.util.ArrayList;
import java.util.List;

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
 * 2021/5/19 : Create DefaultActionInvoation.java
 * -----------------------------------------------------------------
 */
public class DefaultActionInvoation implements ActionInvocation {

    int index = 0;

    private Action action;

    private List<Interceptor> interceptors = new ArrayList<Interceptor>();


    /**
     * Get action
     *
     * @return Action the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Set action
     *
     * @param action Action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }


    /**
     * Set interceptors
     *
     * @param interceptors List<Interceptor> the interceptors to set
     */
    public void addInterceptor(Interceptor interceptors) {
        this.interceptors.add(interceptors);
    }


    @Override
    public String invoke() {//递归调用
        // TODO Auto-generated method stub
        String result = "";
        if (index == interceptors.size()) {
            result = action.execute();
        } else {
            Interceptor interceptor = interceptors.get(index);
            index++;
            result = interceptor.intercept(this);
        }
        return result;
    }

}