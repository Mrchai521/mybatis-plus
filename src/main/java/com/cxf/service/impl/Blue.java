package com.cxf.service.impl;

import com.cxf.service.Color;

/**
 * @author xfchai
 * @ClassName Blue.java
 * @Description 蓝色
 * @createTime 2020/12/01 09:51:00
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("这是蓝色fill方法。。");

    }
}
