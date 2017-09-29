package ren.yale.android.androidbaseframe;

import ren.yale.android.androidbaseframe.common.ImageLoader;
import ren.yale.android.androidbaseframe.common.Navigate;
import ren.yale.android.androidbaseframe.data.ApiManager;
import ren.yale.android.androidbaseframe.data.db.StoreRoom;
import ren.yale.android.basemvplib.BaseApp;

/**
 * Created by yale on 2017/9/28.
 */

public class App extends BaseApp{

    @Override
    public void onCreate() {
        super.onCreate();

        Navigate.init(this);
        ApiManager.getInstance().init(this);
        ImageLoader.getInstance().init(this);
        StoreRoom.getInstance().init(this);
    }
}
