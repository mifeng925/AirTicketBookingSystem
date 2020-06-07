package com.bee.airsystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/5 19:47
 */
public class TimeUtils {

    /**
     * 获取现在时间
     *
     * @return 格式化输出时间 2020-02-20 20：20：20
     */
    public static String nowTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
