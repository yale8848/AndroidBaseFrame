package ren.yale.android.androidbaseframe.data.api;


import ren.yale.android.androidbaseframe.data.bean.Test;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yale on 2017/9/28.
 */

public interface TestApi {
    @GET("test")
    Observable<Test> test();
}
