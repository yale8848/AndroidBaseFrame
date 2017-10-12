package ren.yale.android.androidbaseframe.ui.test.list;

/**
 * Created by yale on 2017/10/12.
 */

public interface CommonRefresh {
    void autoRefresh();//自动刷新
    void autoLoadmore();//自动加载
    void finishRefresh();//结束刷新
    void finishLoadmore();//结束加载
    void finishRefresh(int delay);//结束刷新
    void finishLoadmore(int delay);//结束加载
    void setEnableRefresh(boolean enableRefresh);
    void setEnableLoadmore(boolean enableLoadmore);
}
