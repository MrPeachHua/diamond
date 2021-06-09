/**
 * 上海只二网络科技有限公司
 * <p>
 * Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.fd.diamond.controller;

import com.fd.diamond.mappers.master.UserMapper;
import com.fd.diamond.model.JwtUser;
import com.fd.diamond.model.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName TestController
 *@Description XXX
 *@Author hua
 *@Date 2020/12/9 23:21
 *@Version V1
 **/
@Slf4j
@RestController
@RequestMapping(value = "/")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${test.user}")
    private String testUser;

    @RequestMapping(value = "/api/test",method = RequestMethod.GET)
    public String test(@AuthenticationPrincipal JwtUser adminUser){
        return testUser;
    }

    @RequestMapping(value = "/api/notneedlogin/login",method = RequestMethod.GET)
    public String notNeadLogin(){
        return "test";
    }

    @RequestMapping(value = "/api/test/pdf",method = RequestMethod.GET)
    public String testPdf(){
        String url = "D:\\pdf\\20191210103617476.pdf";
//        FileReader fileReader = new FileReader();

        return "test";
    }

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\word.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = null;
        List<String> result = new ArrayList<>();
        while((temp = bufferedReader.readLine())!=null){
            System.out.println(temp);
            result.add(temp);
        }
        System.out.println(temp);
    }
}
