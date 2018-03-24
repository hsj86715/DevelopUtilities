package cn.com.farmcode.utility.widgets.cirlescale;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static cn.com.farmcode.utility.widgets.cirlescale.ScaleMode.CLOCK;
import static cn.com.farmcode.utility.widgets.cirlescale.ScaleMode.COMPASS;
import static cn.com.farmcode.utility.widgets.cirlescale.ScaleMode.RADAR;
import static cn.com.farmcode.utility.widgets.cirlescale.ScaleMode.SPEED;
import static cn.com.farmcode.utility.widgets.cirlescale.ScaleMode.UNDEFINED;

@IntDef({UNDEFINED, CLOCK, COMPASS, RADAR, SPEED})
@Retention(RetentionPolicy.SOURCE)
public @interface ScaleMode {
    int UNDEFINED = -1, COMPASS = 0, CLOCK = 1, RADAR = 2, SPEED = 3;
}
