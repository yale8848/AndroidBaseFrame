package ren.yale.android.androidbaseframe.ui.test;


import ren.yale.android.androidbaseframe.data.bean.Test;
import ren.yale.android.basemvplib.base.BaseModel;
import ren.yale.android.basemvplib.base.BasePresenter;
import ren.yale.android.basemvplib.base.BaseView;
import ren.yale.android.basemvplib.rx.BaseObservable;

/**
 * Created by yale on 2017/9/28.
 */

public interface TestContract {

    interface View extends BaseView {
        void getTestSuccess(Test test);
    }
    interface  Model extends BaseModel {
        BaseObservable<Test> getTest();

    }
    abstract  class Presenter extends BasePresenter<Model,View>{
        abstract void getTest();
    }
}
