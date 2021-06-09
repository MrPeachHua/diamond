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

package com.fd.diamond.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 *@ClassName UserEntity
 *@Description XXX
 *@Author hua
 *@Date 2020/12/12 19:40
 *@Version V1
 **/
@Data
@Table(name = "t_user")
public class UserEntity {
    @Column(name = "name")
    private String name;
}
