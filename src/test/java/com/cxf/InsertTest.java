package com.cxf;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxf.entity.User;
import com.cxf.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.*;

/**
 * @author xfchai
 * @ClassName InsertTest.java
 * @Description TODO
 * @createTime 2020/11/27 09:46:00
 */
//指定可以在Spring环境下进行junit测试
@RunWith(SpringRunner.class)
//标识该类是springboot测试类，并指定启动该类
@SpringBootTest(classes = MybatisApplication.class)
public class InsertTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void instert() {
        User user = new User();
        user.setName("Junit测试");
        user.setAge(10);
        user.setEmail("123456789@163.com");
        int i = userMapper.insert(user);
        System.out.println("受影响" + i + "行");
    }

    /**
     * 根据id删除
     */
    @Test
    public void delete() {
        int i = userMapper.deleteById(1);
        System.out.println("影响记录数：" + i);
    }

    /**
     * 提供一个Map，Map中记录删除条件，进行删除
     */
    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("age", 20);
        int i = userMapper.deleteByMap(map);
        System.out.println("影响记录数：" + i);
    }

    @Test
    public void deleteByIds() {
        Arrays.asList(1, 3, 2);
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        userMapper.deleteBatchIds(list);
    }

    /**
     * 使用条件构造器，进行删除
     */
    @Test
    public void deleteByWrapper() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(User::getAge, 27).or().gt(User::getAge, 40);
        int i = userMapper.delete(lambdaQueryWrapper);
        System.out.println("影响记录数：" + i);
    }

    /**
     * 更新测试
     * 更新条件和更新信息放在实体，按主键Id更新
     */
    @Test
    public void update() {
        User user = new User();
        user.setName("测试更新");
        user.setAge(10);
        user.setEmail("1215648494789@163.com");
        user.setId(4L);
        int i = userMapper.updateById(user);
        System.out.println("受影响数：" + i);
    }

    /**
     * 更新信息放在实体，更新条件使用条件构造器，进行更新
     */
    @Test
    public void updateWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "柴新峰").eq("age", 20);
        User user = new User();
        user.setEmail("更新信息放在实体126185@qq.com");
        user.setAge(30);
        int i = userMapper.update(user, updateWrapper);
        System.out.println("影响记录数：" + i);
    }

    /**
     * UpdateWrapper创建时传入更新实体
     */
    @Test
    public void updateWrapper2() {
        User user = new User();
        user.setName("UpdateWrapper创建时传入更新实体");
        user.setEmail("1261853718@qq.com");
        user.setAge(25);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>(user);
        int i = userMapper.update(user, updateWrapper);
        System.out.println("受影响行：" + i);
    }

    /**
     * 通过UpdateWrapper进行条件设置，并且通过set方法设置新值
     */
    @Test
    public void updateWrapper3() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "柴新峰").eq("age", 20).set("age", 30);
        int i = userMapper.update(null, updateWrapper);
        System.out.println("受影响行：" + i);
    }

    /**
     * 通过UpdateWrapper进行条件设置，并且通过set方法设置新值
     */
    @Test
    public void updateWrapper4() {
        LambdaUpdateWrapper<User> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(User::getName, "柴新峰").eq(User::getAge, 20).set(User::getAge, 30);
        int i = userMapper.update(null, updateWrapper);
        System.out.println("受影响行：" + i);
    }

    /**
     * 另外一种Lambda表达式方式
     */
    @Test
    public void updateWrapper5() {
        LambdaUpdateChainWrapper<User> updateWrapper = new LambdaUpdateChainWrapper<>(userMapper);
        boolean b = updateWrapper.eq(User::getName, "柴新峰").eq(User::getAge, 20).set(User::getAge, 40).update();
        System.out.println("是否更新成功:" + b);
    }

    /**
     * 根据id查询
     */
    @Test
    public void selectById() {
        User user = userMapper.selectById(1332140739114221570L);
        System.out.println(user);
    }

    /**
     * 一次使用多个id查询
     */
    @Test
    public void selectIds() {
        List<Long> list = new ArrayList<>();
        list.add(4L);
        list.add(5L);
        List<User> userList = userMapper.selectBatchIds(list);
        userList.forEach(user -> System.out.println(user));
    }

    /**
     * 使用Mao存放查询字段和条件来进行查询
     */
    @Test
    public void selectByMap() {
        //Map存放查询条件，注意key存放的是数据库的字段名，而不是实体中的变量名
        Map<String, Object> map = new HashMap<>();
        map.put("name", "柴新峰");
        map.put("age", 40);
        List<User> list = userMapper.selectByMap(map);
        list.forEach(user -> System.out.println(user));
    }

    /**
     * 使用条件构造器进行查询
     */
    @Test
    public void selectByWrapper() {
        //直接创建一个条件构造器，获取使用Wrappers工具类
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //模糊查询，注意这里的字段都是数据库字段，而不是实体的变量名
        queryWrapper.like("name", "柴").lt("age", 90);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(user -> System.out.println(user));
    }

    /**
     * 使用条件构造器进行查询
     */
    @Test
    public void selectWrapper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "柴").between("age", 20, 90).isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(user -> System.out.println(user));
    }

    /**
     * 使用条件构造器进行查询
     */
    @Test
    public void selectWrapper3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeLeft("name", "柴").gt("age", 20).orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(user -> System.out.println(user));
    }

    /**
     * 分页查询
     */
    @Test
    public void selectPage() {
        //直接创建一个条件构造器，获取Wrappers工具类
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 26);
        Page<User> page = new Page<>(1, 2);
        //分页
        IPage<User> pageUser = userMapper.selectPage(page, queryWrapper);
        System.out.println("获取总页数：" + pageUser.getPages());
        System.out.println("总记录数：" + pageUser.getRecords());
        List<User> list = pageUser.getRecords();
        list.forEach(user -> System.out.println(user));
    }
}

