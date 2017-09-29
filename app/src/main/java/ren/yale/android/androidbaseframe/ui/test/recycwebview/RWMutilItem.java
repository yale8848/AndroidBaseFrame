package ren.yale.android.androidbaseframe.ui.test.recycwebview;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by yale on 2017/9/29.
 */

public class RWMutilItem implements MultiItemEntity {

    public static final int WEBVIEW = 0;
    public static final int LIST = 1;

    private int mType = 0;

    public RWMutilItem(int type){
        mType = type;
    }

    @Override
    public int getItemType() {
        return mType;
    }
}
