package com.chen17.doexcel.utils;

import com.chen17.doexcel.domain.FromParentData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-18 10:38
 */
public class ChangeDataFormat {

    Date today;

    public ChangeDataFormat(FromParentData fromParentData) {
        this.today = fromParentData.getDate();
    }

    public String getToday() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
        return simpleDateFormat.format(today);
    }

    public String getYesterday() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
        //获取昨天日期
        return  simpleDateFormat.format(new Date(today.getTime() - 1000 * 60 * 60 * 24));

    }
}
