package com.higgsup.common.utils;

import java.util.List;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
public class DataUtils {

    public static boolean isNull(Object value) {
        return value == null ;
    }

    public static boolean isNullOrEmpty(String value) {
        if(value == null || "".equals(value.trim())) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(List values) {
        if(values == null || values.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrZezo(Long value) {
        if(value == null || value == 0 ) {
            return true;
        }
        return false;
    }
}
