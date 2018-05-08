package cn.com.farmcode.utility.tools;

import android.os.SystemClock;
import android.util.AndroidRuntimeException;

/**
 * A util to count time by milliseconds since boot, including time spent in sleep.
 *
 * @author hushujun
 */
public class TimeCounter {
    private static long sStart;
    private static long sStep;
    private static long sStepStart;

    /**
     * Start count time cost
     */
    public static void start() {
        sStart = SystemClock.elapsedRealtime();
        sStep = 0;
    }

    /**
     * This must called after {@link #start()}, or it will throw an {@link AndroidRuntimeException}.
     * Once this method called, the next time call this would be start from the moment of this time.
     *
     * @return the time cost from {@link #start()} or last time called {@link #step()}
     */
    public static long step() {
        if (sStart == 0) {
            throw new AndroidRuntimeException("You Must Call start() first");
        }
        long current = SystemClock.elapsedRealtime();
        long stepCost;
        if (sStep == 0) {
            stepCost = current - sStart;
        } else {
            stepCost = current - sStep;
        }
        sStep = current;
        return stepCost;
    }

    /**
     * Start a step time count
     */
    public static void stepStart() {
        long current = SystemClock.elapsedRealtime();
        if (sStart == 0) {
            sStart = current;
            sStep = 0;
        }
        sStepStart = current;
    }

    /**
     * @return the time cost from {@link #stepStart()}
     */
    public static long stepEnd() {
        if (sStepStart == 0) {
            throw new AndroidRuntimeException("You Must Call stepStart() first");
        }
        long current = SystemClock.elapsedRealtime();
        long cost = current - sStepStart;
        sStepStart = 0;
        return cost;
    }

    /**
     * This must called after {@link #start()}, or it will throw an {@link AndroidRuntimeException}.
     * This will move the cursor of STEP to the current moment.
     *
     * @return the time cost from {@link #start()} to this moment, not care how many steps has called before this
     */
    public static long stepTotal() {
        if (sStart == 0) {
            throw new AndroidRuntimeException("You Must Call start()first");
        }
        long current = SystemClock.elapsedRealtime();
        sStep = current;
        return current - sStart;
    }

    /**
     * This must called after {@link #start()}, or it will throw an {@link AndroidRuntimeException}.
     * If the counter stopped, need to call {@link #start()} to start a new time counter.
     *
     * @return the total time cost from{@link #start()}
     */
    public static long stop() {
        if (sStart == 0) {
            throw new AndroidRuntimeException("You Must Call start() first");
        }
        long totalCost = SystemClock.elapsedRealtime() - sStart;
        sStart = 0;
        return totalCost;
    }
}
