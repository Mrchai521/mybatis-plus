package com.cxf.service.impl;

import com.cxf.service.Shape;

/**
 * @author xfchai
 * @ClassName Rectangle.java
 * @Description 三角形
 * @createTime 2020/12/01 09:37:00
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("这是三角形得draw()方法。。。Inside Rectangle::draw() method.");
    }
}
