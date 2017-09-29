package ren.yale.android.androidbaseframe.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.EventBusUtil;
import ren.yale.android.basemvplib.base.BaseModel;
import ren.yale.android.basemvplib.base.BasePresenter;
import ren.yale.android.basemvplib.base.MVPActivity;

/**
 * Created by yale on 2017/9/28.
 */

public class BaseMVPActivity<P extends BasePresenter,M extends BaseModel> extends MVPActivity<P,M> {

    private ImmersionBar mImmersionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImmersionBar = ImmersionBar.with(this)
                .statusBarColor(R.color.colorPrimary)
                .navigationBarColor(R.color.colorPrimary)
                .transparentBar();
        mImmersionBar.init();
        EventBusUtil.register(this);
    }

    protected  Dialog getProgressDlg(){
        return new Dialog(this);
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
