package com.wei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //日期转化为字符串
    public static String Date2String(Date date,String parttern){
        SimpleDateFormat sdf=new SimpleDateFormat(parttern);
        String format = sdf.format(date);
        return format;
    }
    //字符串转化为日期
    public static Date String2Date(String str,String parttern) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(parttern);
        Date parse = sdf.parse(str);
        return parse;
    }
}
