package ren.yale.android.androidbaseframe.ui.Test;


import ren.yale.android.androidbaseframe.data.ApiManager;
import ren.yale.android.androidbaseframe.data.bean.Test;
import ren.yale.android.basemvplib.rx.BaseObservable;

/**
 * Created by yale on 2017/9/28.
 */

public class TestModel implements TestContract.Model {
    @Override
    public BaseObservable<Test> getTest() {
        return BaseObservable.create(ApiManager.getInstance().getTestApi().test())
                .cacheIoMain();
    }
}
