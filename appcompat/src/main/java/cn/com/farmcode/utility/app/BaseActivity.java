package cn.com.farmcode.utility.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initConfig();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
    }

    protected void initConfig() {

    }

    abstract int getLayoutResId();

    abstract void initView();
}
