package ren.yale.android.androidbaseframe.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.EventBusUtil;

import static ren.yale.android.androidbaseframe.common.EventBusUtil.register;

/**
 * Created by yale on 2017/9/28.
 */

public class BaseSimpleActivity extends AppCompatActivity {

    private ImmersionBar mImmersionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mImmersionBar = ImmersionBar.with(this)
                .statusBarColor(R.color.colorPrimary)
                .navigationBarColor(R.color.colorPrimary);
        mImmersionBar.init();
        EventBusUtil.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar!=null){
            mImmersionBar.destroy();
        }
        EventBusUtil.unRegister(this);
    }
}
