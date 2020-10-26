package com.example.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;

/**
 * @version: 1.00.00
 * @description: 通用工具类
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-05-15 15:24
 */
public class CommonUtil {

    public static String generateUnique() {
        return StringUtils.join(new String[]{DateFormatUtils.format(Calendar.getInstance().getTime(), "yyyyMMddHHmmssSSS"), RandomStringUtils.randomNumeric(3)});
    }

}
