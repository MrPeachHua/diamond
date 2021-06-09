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

package com.fd.diamond.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@ClassName AdminUser
 *@Description XXX
 *@Author hua
 *@Date 2020/12/11 18:19
 *@Version V1
 **/
@Data
public class JwtUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    private final String id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;

    public JwtUser(
            String id,
            String username,
            String password, List<String> authorities,
            boolean enabled
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = mapToGrantedAuthorities(authorities);
        this.enabled = enabled;
    }
    public JwtUser(
            String id,
            String username,
            String password, String authoritie,
            boolean enabled
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = mapToGrantedAuthorities(authoritie);
        this.enabled = enabled;
    }
    private List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }
    private List<GrantedAuthority> mapToGrantedAuthorities(String authoritie) {
        return Arrays.asList(new SimpleGrantedAuthority(authoritie));
    }
    public String getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}