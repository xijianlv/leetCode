package com.xijianlv.leetcode.test;


import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws Exception {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        String dateStr = sdf.format(date);
//        String substring = dateStr.substring(11, 16);
//        long timeStamp = calTimeStamp(substring, true);
//        System.out.println();

//        String str = "{}";
//        JSONObject objects = JSONObject.parseObject(str);
//
//        System.out.println(objects.values().isEmpty());
//        System.out.println(str + 1);

//        Process exec = Runtime.getRuntime().exec("/home/idriver/xx.sh xijian");
//        String[] cmd = {"/home/idriver/xx.sh","xijianlv"};
//        Process exec = Runtime.getRuntime().exec("play /home/idriver/Downloads/work_doc/washingVehicle/语音包通用版_en_V0.3/PowerOn_en.mp3");
//
//        Class<? extends Process> clz = exec.getClass();
//
//        Field fieldPid = clz.getDeclaredField("pid");
//        Field fieldHasExited = clz.getDeclaredField("hasExited");
//        Field fieldExitCode = clz.getDeclaredField("exitcode");
//
//        fieldPid.setAccessible(true);
//        fieldHasExited.setAccessible(true);
//        fieldExitCode.setAccessible(true);
//
//        System.out.println(fieldPid.get(exec));
//        System.out.println(fieldHasExited.get(exec));
//        System.out.println(fieldExitCode.get(exec));
//        System.out.println();
//
//
//        TimeUnit.SECONDS.sleep(1);
//
//        exec.destroy();
//        exec.waitFor();
//
//        System.out.println(fieldPid.get(exec));
//        System.out.println(fieldHasExited.get(exec));
//        System.out.println(fieldExitCode.get(exec));

    }

    /**
     * 根据时分计算时间戳 格式 hh:mm
     *
     * @param str               时间字符串
     * @param isTomorrowEndDate 是否明天
     * @return
     */
    public static long calTimeStamp(String str, Boolean isTomorrowEndDate) {
        try {
            if (StringUtils.isEmpty(str)) {
                return -1;
            }
            Calendar calendar = Calendar.getInstance();
            if (Objects.equals(Boolean.TRUE, isTomorrowEndDate)) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(str.split(":")[0]));
            calendar.set(Calendar.MINUTE, Integer.parseInt(str.split(":")[1]));
            calendar.set(Calendar.SECOND, 0);
            return calendar.getTimeInMillis();
        } catch (Exception e) {
            return -1;
        }
    }

}
