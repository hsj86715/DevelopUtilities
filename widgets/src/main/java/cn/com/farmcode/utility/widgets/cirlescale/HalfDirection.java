package cn.com.farmcode.utility.widgets.cirlescale;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static cn.com.farmcode.utility.widgets.cirlescale.HalfDirection.BOTTOM;
import static cn.com.farmcode.utility.widgets.cirlescale.HalfDirection.LEFT;
import static cn.com.farmcode.utility.widgets.cirlescale.HalfDirection.RIGHT;
import static cn.com.farmcode.utility.widgets.cirlescale.HalfDirection.TOP;
import static cn.com.farmcode.utility.widgets.cirlescale.HalfDirection.UNDEFINED;

@IntDef({UNDEFINED, TOP, RIGHT, BOTTOM, LEFT})
@Retention(RetentionPolicy.SOURCE)
public @interface HalfDirection {
    int UNDEFINED = -1, TOP = 0, RIGHT = 1, BOTTOM = 2, LEFT = 3;
}
