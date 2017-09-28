package ren.yale.android.androidbaseframe.ui.test;


import ren.yale.android.androidbaseframe.data.bean.Test;
import ren.yale.android.basemvplib.rx.subscribe.ProgressSubscriber;

/**
 * Created by yale on 2017/9/28.
 */
public class TestPresenter extends TestContract.Presenter {

    public void getTest(){
        mModel.getTest().bindDestoryEvent(getPublishSubject())
                .subscribe(new ProgressSubscriber<Test>(){
                    @Override
                    public void onNext(Test test) {
                        mView.getTestSuccess(test);
                    }
                });
    }

}
