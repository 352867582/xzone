package com.xzone.admin;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzone.xinterface.shopUsers.model.ShopUsers;
import com.xzone.xinterface.shopUsers.service.ShopUsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

    @Resource
    private ShopUsersService shopUsersService;

    @Test
    public void contextLoads() {
        IPage<ShopUsers> page = shopUsersService.page(new Page<>(1, 5), new QueryWrapper<>());
        System.out.println(JSON.toJSONString(page));
    }

}

