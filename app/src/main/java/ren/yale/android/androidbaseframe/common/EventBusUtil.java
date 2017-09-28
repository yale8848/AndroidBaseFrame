package ren.yale.android.androidbaseframe.common;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yale on 2017/9/28.
 */

public class EventBusUtil {

    public static void register(Object object){
        EventBus.getDefault().register(object);
    }
    public static void unRegister(Object object){
        EventBus.getDefault().unregister(object);
    }
    public static void post(Object object){
        EventBus.getDefault().post(object);
    }
}
