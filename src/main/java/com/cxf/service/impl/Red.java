package com.cxf.service.impl;

import com.cxf.service.Color;

/**
 * @author xfchai
 * @ClassName Red.java
 * @Description 红色
 * @createTime 2020/12/01 09:49:00
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("画红色得fill方法。。。");
    }
}
