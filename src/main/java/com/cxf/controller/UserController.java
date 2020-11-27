package com.cxf.controller;

import com.cxf.entity.User;
import com.cxf.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author xfchai
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020/11/26 11:01:00
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public void findAllUser() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @GetMapping("/runnable")
    public void runnable() {
        //调用thread方法
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "--->线程已开启！");
            }
        });
        //使用lambda表达式
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "--->LAMBA线程已开启！");
        });
        //优化lambda表达式
        startThread(() -> System.out.println("优化后的lambda线程开启"));
        //调用comparator
        getComparator();
        createList();
    }

    private static void startThread(Runnable runnable) {
        //开启多线程
        new Thread(runnable).start();
    }

    private static Comparator<String> getComparator() {
       /* return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        };*/
        return (String o1, String o2) -> o2.length() - o1.length();
    }

    private static void createList(){
        List<String> list = new ArrayList<>();
        list.add("chaxinfeng");
        list.add("柴新峰");
        list.add("周杰伦");
        list.add("林俊杰");
        list.add("张小明");
        list.add("张华");
        //过滤
        list.stream().filter((name)->name.startsWith("张"))
                .filter((name)->name.length()==3)
                .forEach(name-> System.out.println(name));
    }
}
