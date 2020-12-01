package com.cxf.service.impl;

import com.cxf.service.Color;

/**
 * @author xfchai
 * @ClassName Green.java
 * @Description 绿色
 * @createTime 2020/12/01 09:50:00
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("这是画绿色得方法。。。");
    }
}
