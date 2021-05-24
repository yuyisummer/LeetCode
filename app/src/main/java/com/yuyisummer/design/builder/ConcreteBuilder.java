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
 * 2021/5/14 : Create ConcreteBuilder.java
 * -----------------------------------------------------------------
 */
public class ConcreteBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("Builder PartA");
    }

    public void buildPartB() {
        product.setPartB("Builder PartB");
    }

    public void buildPartC() {
        product.setPartC("Builder PartC");
    }
}
