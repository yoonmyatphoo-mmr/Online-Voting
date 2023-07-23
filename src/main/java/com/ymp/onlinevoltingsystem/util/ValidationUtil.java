package com.ymp.onlinevoltingsystem.util;

/**
 * @Author Yoon Myat Phoo
 * @created 7/23/2023
 * @project online-voting-system
 * @package com.ymp.onlinevotingsystem.util
 */
public class ValidationUtil {
    public static boolean isValidString(String value){
        if(value == null || value.trim().equals(""))
            return false;
        return true;
    }
}
