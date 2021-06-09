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

package com.fd.diamond.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *@ClassName JwtResponse
 *@Description XXX
 *@Author hua
 *@Date 2020/12/11 19:34
 *@Version V1
 **/
@Data
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jwttoken;
    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}