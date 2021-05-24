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
 * 2021/5/14 : Create Client.java
 * -----------------------------------------------------------------
 */
class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}
