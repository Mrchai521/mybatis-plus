package com.cxf.holder;

import com.cxf.service.Color;
import com.cxf.service.Shape;
import com.cxf.service.impl.Blue;
import com.cxf.service.impl.Green;
import com.cxf.service.impl.Red;
import org.springframework.util.StringUtils;

/**
 * @author xfchai
 * @ClassName ColorFactory.java
 * @Description 颜色工厂
 * @createTime 2020/12/01 10:05:00
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (StringUtils.isEmpty(color)) {
            return null;
        }
        if (color.equalsIgnoreCase("red")) {
            return new Red();
        } else if (color.equalsIgnoreCase("green")) {
            return new Green();
        } else if (color.equalsIgnoreCase("blue")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
