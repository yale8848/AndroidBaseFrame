package ren.yale.android.androidbaseframe.ui.test.data;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.BadgeViewDisplay;
import ren.yale.android.androidbaseframe.common.Navigate;
import ren.yale.android.androidbaseframe.data.bean.Test;
import ren.yale.android.androidbaseframe.data.db.StoreRoom;
import ren.yale.android.androidbaseframe.data.db.entity.StudentEntity;
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
        setContentView(R.layout.test_activity_test);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.getBackground().mutate().setAlpha(200);
        View view = findViewById(R.id.imageView1);

        BadgeViewDisplay.show(this,view);


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

       List<StudentEntity> students =  StoreRoom.getInstance().<StudentEntity>getBox(StudentEntity.class).box().getAll();
        for (StudentEntity s: students){
            LogUtil.d(s.getId()+" "+s.getName());
        }

    }


}
