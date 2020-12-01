package com.cxf.service.impl;

import com.cxf.service.Shape;

/**
 * @author xfchai
 * @ClassName Circle.java
 * @Description 圆形
 * @createTime 2020/12/01 09:48:00
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("这是圆形得draw方法！！！");
    }
}
