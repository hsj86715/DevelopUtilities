package cn.com.farmcode.utility.tools;

/**
 * Created by hushujun on 2018/3/22.
 *
 * @author hushujun
 */

public class Tools {
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * @param str if null return ""
     * @return if str is null return "", else return itself
     */
    public static String safeString(String str) {
        if (isNull(str)) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * @param str if null return null
     * @return string bite array
     */
    public static byte[] getStringByte(String str) {
        if (isNull(str)) {
            return null;
        } else {
            return str.getBytes();
        }
    }
}
