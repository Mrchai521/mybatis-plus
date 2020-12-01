package com.cxf;

import com.cxf.controller.FactoryProducer;
import com.cxf.holder.AbstractFactory;
import com.cxf.service.Color;
import com.cxf.service.Shape;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * @author xfchai
 * @ClassName FactoryTest.java
 * @Description 工厂类测试
 * @createTime 2020/12/01 10:11:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class FactoryTest {
    @Test
    public void test() {
        AbstractFactory abstractFactory = FactoryProducer.getFactory("shape");
        Shape shape = abstractFactory.getShape("circle");
        shape.draw();
        Shape shape1 = abstractFactory.getShape("rectancle");
        if (!StringUtils.isEmpty(shape1)) {
            shape1.draw();
        }
        Shape shape2 = abstractFactory.getShape("square");
        if (!StringUtils.isEmpty(shape2)) {
            shape2.draw();
        }
        System.out.println("=====================================================");
        AbstractFactory abstractFactory1 = FactoryProducer.getFactory("color");
        Color color = abstractFactory1.getColor("red");
        if (!StringUtils.isEmpty(color)) {
            color.fill();
        }

        Color blue = abstractFactory1.getColor("blue");
        if (!StringUtils.isEmpty(blue)) {
            blue.fill();
        }
        Color green = abstractFactory1.getColor("green");
        if (!StringUtils.isEmpty(green)) {
            green.fill();
        }
    }
}
