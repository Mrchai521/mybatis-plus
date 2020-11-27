package com.cxf.entity;

import lombok.Data;

/**
 * @author xfchai
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020/11/26 10:57:00
 */
@Data
public class User {
    /**
     * 用户id
     */
    private Long id;
    //用户姓名
    private String name;
    //用户年龄
    private int age;
    //用户邮箱
    private String email;
}
