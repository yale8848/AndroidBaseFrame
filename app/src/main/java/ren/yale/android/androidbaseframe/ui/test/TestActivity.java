package ren.yale.android.androidbaseframe.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.Navigate;
import ren.yale.android.androidbaseframe.data.bean.Test;
import ren.yale.android.androidbaseframe.data.event.EventTest;
import ren.yale.android.androidbaseframe.ui.BaseMVPActivity;
import ren.yale.android.androidbaseframe.util.LogUtil;

/**
 * Created by yale on 2017/9/28.
 */

@Route(path  = Navigate.PATH.Test)
public class TestActivity extends BaseMVPActivity<TestPresenter,TestModel>  implements TestContract.View{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onClick(View v){
        mPresenter.getTest();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventTest eventTest){

    }

    @Override
    public void getTestSuccess(Test test) {
        LogUtil.d(test.getMessage());
    }


}
