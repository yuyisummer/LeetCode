package com.yuyisummer.design.builder;

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
 * 2021/5/14 : Create Builder.java
 * -----------------------------------------------------------------
 */
abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}
