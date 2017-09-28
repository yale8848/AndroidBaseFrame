package ren.yale.android.androidbaseframe.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import ren.yale.android.androidbaseframe.common.EventBusUtil;

/**
 * Created by yale on 2017/9/28.
 */

public class BaseSimpleFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBusUtil.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBusUtil.unRegister(this);
    }
}
