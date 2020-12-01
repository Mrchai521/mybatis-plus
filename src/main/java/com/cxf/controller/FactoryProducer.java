package com.cxf.controller;

import com.cxf.holder.AbstractFactory;
import com.cxf.holder.ColorFactory;
import com.cxf.holder.ShapeFactory;

/**
 * @author xfchai
 * @ClassName FactoryProducer.java
 * @Description 工厂创造器
 * @createTime 2020/12/01 10:08:00
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
