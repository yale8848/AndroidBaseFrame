package ren.yale.android.androidbaseframe.common;

import android.app.Application;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by yale on 2017/9/28.
 */

public class Navigate {

    public interface PATH{
        String Test = "/ui/test";
    }



    public static void init(Application context){
        ARouter.init(context);
        ARouter.openLog();
        ARouter.openDebug();

    }

    public static Postcard path(String path){
       return ARouter.getInstance()
                .build(path);
    }
}
