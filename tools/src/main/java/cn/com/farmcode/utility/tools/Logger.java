package cn.com.farmcode.utility.tools;

import android.util.Log;

/**
 * Created by hushujun on 2017/10/27.
 */

public final class Logger {
    private static final String DEFTAG = "Logger";
    private static boolean isPrintAble = true;
    private static boolean containTrace = true;

    private static String getStack() {
        if (!containTrace) {
            return "";
        }
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements != null && elements.length >= 5) {
//            System.out.println("=====getStack======");
//            for (StackTraceElement element : elements) {
//                System.out.println(element.toString());
//            }
            return elements[4].getFileName() + "#" + elements[4].getMethodName() + "(line " +
                    elements[4].getLineNumber() + "): ";
        }
        return "";
    }

    private static String getDefaultTag() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements != null && elements.length >= 5) {
//            System.out.println("=====getDefaultTag======");
//            for (StackTraceElement element : elements) {
//                System.out.println(element.toString());
//            }
            return elements[4].getFileName();
        }
        return DEFTAG;
    }

    public static void setPrintAble(boolean printAble) {
        isPrintAble = printAble;
    }

    public static void setContainTrace(boolean trace) {
        containTrace = trace;
    }

    public static void v(String TAG, String msg) {
        if (isPrintAble) {
            Log.v(TAG, getStack() + msg);
        }
    }

    public static void v(String TAG, String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.v(TAG, getStack() + msg, throwable);
        }
    }

    public static void d(String TAG, String msg) {
        if (isPrintAble) {
            Log.d(TAG, getStack() + msg);
        }
    }

    public static void d(String TAG, String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.d(TAG, getStack() + msg, throwable);
        }
    }

    public static void i(String TAG, String msg) {
        if (isPrintAble) {
            Log.i(TAG, getStack() + msg);
        }
    }

    public static void i(String TAG, String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.i(TAG, getStack() + msg, throwable);
        }
    }

    public static void w(String TAG, String msg) {
        if (isPrintAble) {
            Log.w(TAG, getStack() + msg);
        }
    }

    public static void w(String TAG, String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.w(TAG, getStack() + msg, throwable);
        }
    }

    public static void e(String TAG, String msg) {
        if (isPrintAble) {
            Log.e(TAG, getStack() + msg);
        }
    }

    public static void e(String TAG, String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.e(TAG, getStack() + msg, throwable);
        }
    }

    public static void v(String msg) {
        if (isPrintAble) {
            Log.v(getDefaultTag(), getStack() + msg);
        }
    }

    public static void v(String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.v(getDefaultTag(), getStack() + msg, throwable);
        }
    }

    public static void d(String msg) {
        if (isPrintAble) {
            Log.d(getDefaultTag(), getStack() + msg);
        }
    }

    public static void d(String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.d(getDefaultTag(), getStack() + msg, throwable);
        }
    }

    public static void i(String msg) {
        if (isPrintAble) {
            Log.i(getDefaultTag(), getStack() + msg);
        }
    }

    public static void i(String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.i(getDefaultTag(), getStack() + msg, throwable);
        }
    }

    public static void w(String msg) {
        if (isPrintAble) {
            Log.w(getDefaultTag(), getStack() + msg);
        }
    }

    public static void w(String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.w(getDefaultTag(), getStack() + msg, throwable);
        }
    }

    public static void e(String msg) {
        if (isPrintAble) {
            Log.e(getDefaultTag(), getStack() + msg);
        }
    }

    public static void e(String msg, Throwable throwable) {
        if (isPrintAble) {
            Log.e(getDefaultTag(), getStack() + msg, throwable);
        }
    }
}
