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

package com.fd.diamond.common.component;

/**
 *@ClassName JwtUserDetailsService
 *@Description XXX
 *@Author hua
 *@Date 2020/12/11 19:39
 *@Version V1
 **/
import com.fd.diamond.model.JwtUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * JwtUserDetailsService
 *	 	实现UserDetailsService,重写loadUserByUsername方法
 *  	返回随机生成的user,pass是密码,这里固定生成的
 *  	如果你自己需要定制查询user的方法,请改造这里
 * @author zhengkai.blog.csdn.net
 */
@Service
public class JwtUserDetailsService implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String username) {
        String pass = new BCryptPasswordEncoder().encode("pass");
        if (StringUtils.isNotEmpty(username)&&username.contains("user")) {
            return new JwtUser(RandomStringUtils.random(8), username,pass,"USER", true);
        } else {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
    }
}
