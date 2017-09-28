package ren.yale.android.androidbaseframe.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ren.yale.android.androidbaseframe.common.EventBusUtil;
import ren.yale.android.basemvplib.base.BaseModel;
import ren.yale.android.basemvplib.base.BasePresenter;
import ren.yale.android.basemvplib.base.MVPFragment;

/**
 * Created by yale on 2017/9/28.
 */

public class BaseMVPFragment<P extends BasePresenter,M extends BaseModel> extends MVPFragment {

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
