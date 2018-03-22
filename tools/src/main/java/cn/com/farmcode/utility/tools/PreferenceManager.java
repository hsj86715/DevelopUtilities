package cn.com.farmcode.utility.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.Set;

/**
 * @author hushujun
 */

public class PreferenceManager {
    private static final String FILE_NAME = "cn_com_farmcode_utility_spf.xml";

    public static void put(Context context, String key, Object value) {
        if (Tools.isNull(value) || TextUtils.isEmpty(key)) {
            return;
        }
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (int) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (long) value);
        } else {
            editor.putString(key, value.toString());
        }
        editor.apply();
    }

    public static void putStringSet(Context context, String key, Set<String> value) {
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public static Object get(Context context, String key, Object defValue) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        if (defValue instanceof String) {
            return spf.getString(key, (String) defValue);
        } else if (defValue instanceof Boolean) {
            return spf.getBoolean(key, (boolean) defValue);
        } else if (defValue instanceof Integer) {
            return spf.getInt(key, (int) defValue);
        } else if (defValue instanceof Float) {
            return spf.getFloat(key, (float) defValue);
        } else if (defValue instanceof Long) {
            return spf.getLong(key, (long) defValue);
        } else if (defValue instanceof Set) {
            return spf.getStringSet(key, (Set<String>) defValue);
        } else {
            return spf.getString(key, null);
        }
    }

    public static boolean contain(Context context, @NonNull String key) {
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return spf.contains(key);
    }

    public static void remove(Context context, @NonNull String key) {
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.remove(key).apply();
    }

    public static void clear(Context context) {
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.clear().apply();
    }
}
