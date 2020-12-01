package com.cxf.holder;

import com.cxf.service.Color;
import com.cxf.service.Shape;
import com.cxf.service.impl.Circle;
import com.cxf.service.impl.Rectangle;
import org.springframework.util.StringUtils;

/**
 * @author xfchai
 * @ClassName ShapeFactory.java
 * @Description TODO
 * @createTime 2020/12/01 10:00:00
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (StringUtils.isEmpty(shape)) {
            return null;
        }
        if (shape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("rectancle")) {
            return new Rectangle();
        }
        return null;
    }
}
