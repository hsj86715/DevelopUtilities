package cn.com.farmcode.utility.widgets.cirlescale;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static cn.com.farmcode.utility.widgets.cirlescale.CircleMode.FAN;
import static cn.com.farmcode.utility.widgets.cirlescale.CircleMode.HALF;
import static cn.com.farmcode.utility.widgets.cirlescale.CircleMode.WHOLE;

@IntDef({WHOLE, HALF, FAN})
@Retention(RetentionPolicy.SOURCE)
public @interface CircleMode {
    int WHOLE = 0, HALF = 1, FAN = 2;
}