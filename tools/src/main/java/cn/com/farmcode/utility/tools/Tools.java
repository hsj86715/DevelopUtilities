package cn.com.farmcode.utility.tools;

/**
 * Created by hushujun on 2018/3/22.
 * @author hushujun
 */

public class Tools {
    public static boolean isNull(Object object) {
        return object == null;
    }

    public static String safeString(String str) {
        if (isNull(str)) {
            return "";
        } else {
            return str;
        }
    }
}
