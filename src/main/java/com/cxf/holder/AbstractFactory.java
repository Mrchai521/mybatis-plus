package com.cxf.holder;

import com.cxf.service.Color;
import com.cxf.service.Shape;

/**
 * @author xfchai
 * @ClassName AbstractFactory.java
 * @Description 抽象工厂类
 * @createTime 2020/12/01 09:57:00
 */
public abstract class AbstractFactory {
    /***
     * 获取颜色
     * @param color
     * @return
     */
    public abstract Color getColor(String color);

    /**
     * 获取形状
     *
     * @param shape
     * @return
     */
    public abstract Shape getShape(String shape);
}
