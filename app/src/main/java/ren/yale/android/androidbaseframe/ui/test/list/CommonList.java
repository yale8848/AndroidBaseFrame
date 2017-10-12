package ren.yale.android.androidbaseframe.ui.test.list;

import android.content.Context;
import android.graphics.Color;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by yale on 2017/10/12.
 */

public class CommonList implements CommonRefresh {

    private SmartRefreshLayout mSmartRefreshLayout;
    private Context mContext;

    public CommonList(SmartRefreshLayout smartRefreshLayout ){
        mSmartRefreshLayout = smartRefreshLayout;
        mContext = smartRefreshLayout.getContext();
        smartRefreshLayout.setRefreshHeader(new CommonListHeader(mContext));
        smartRefreshLayout.setBackgroundColor(Color.parseColor("#f0f0f0"));
        ClassicsFooter classicsFooter  = new ClassicsFooter(mContext);
        smartRefreshLayout.setRefreshFooter(classicsFooter);
    }
    public void setBackgroundColor(int resid){
        mSmartRefreshLayout.setBackgroundColor(resid);
    }
    public CommonList dafalutHeader(){
        ClassicsHeader classicsHeader = new ClassicsHeader(mContext);
        mSmartRefreshLayout.setRefreshHeader(classicsHeader);
        return  this;
    }

    public CommonList addRefreshListener(final CommonRefreshListener commonRefreshListener){
        final CommonList  commonList= this;
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                commonRefreshListener.onRefresh(commonList);
            }
        });
        mSmartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                commonRefreshListener.onLoadMore(commonList);
            }
        });
        return this;
    }

    @Override
    public void autoRefresh() {
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    public void autoLoadmore() {
        mSmartRefreshLayout.autoLoadmore();
    }

    @Override
    public void finishRefresh() {
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void finishLoadmore() {
        mSmartRefreshLayout.finishLoadmore();
    }

    @Override
    public void finishRefresh(int delay) {
        mSmartRefreshLayout.finishRefresh(delay);
    }

    @Override
    public void finishLoadmore(int delay) {
        mSmartRefreshLayout.finishLoadmore(delay);
    }

    @Override
    public void setEnableRefresh(boolean enableRefresh) {
        mSmartRefreshLayout.setEnableRefresh(enableRefresh);
    }

    @Override
    public void setEnableLoadmore(boolean enableLoadmore) {
        mSmartRefreshLayout.setEnableLoadmore(enableLoadmore);
    }

}
