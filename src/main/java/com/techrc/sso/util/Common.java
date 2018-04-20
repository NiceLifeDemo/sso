package com.techrc.sso.util;

/**
 * Created by Administrator on 2018/4/20.
 */
public class Common {

    /**
     * 判断变量是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(Object s) {
        if (null == s || "".equals(s) || "".equals(s.toString().trim()) || "null".equalsIgnoreCase(s.toString())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断变量是否为空
     *
     * @param s
     * @return
     */
    public static boolean isNotEmpty(Object s) {
        if (null == s || "".equals(s) || "".equals(s.toString().trim()) || "null".equalsIgnoreCase(s.toString())) {
            return false;
        } else {
            return true;
        }
    }
}
