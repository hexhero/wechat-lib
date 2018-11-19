package com.yangb.weichatmanager.util;

import java.util.Calendar;
import java.util.Date;

/**
 * weichatmanager
 * create by YangBin on 2018/11/19
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class DateUtil {

    /**
     * 加秒
     * @param second
     * @param date
     * @return
     */
    public static Date addSecond(Date date, int second){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND,second);
        return c.getTime();
    }
}
