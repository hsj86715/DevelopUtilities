package cn.com.farmcode.utility.app;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;

public abstract class BaseFragmentActivity extends BaseActivity {
    protected Toolbar mToolbar;

    @LayoutRes
    protected abstract int getContentLayout();

    protected abstract void onContentInflated(View view);

    protected void onNavigationBackClicked() {
        finish();
    }

    @DrawableRes
    protected int getNavigationIcon() {
        return 0;
    }

    @Override
    int getLayoutResId() {
        return R.layout.activity_frag_base;
    }

    @Override
    void initView() {
        mToolbar = findViewById(R.id.activity_frag_toolbar);
        int navigation = getNavigationIcon();
        if (navigation > 0) {
            mToolbar.setNavigationIcon(navigation);
        }
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNavigationBackClicked();
            }
        });

        ViewStub viewStub = findViewById(R.id.activity_frag_content);
        viewStub.setLayoutResource(getContentLayout());
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                onContentInflated(inflated);
            }
        });
        viewStub.inflate();
    }

}
