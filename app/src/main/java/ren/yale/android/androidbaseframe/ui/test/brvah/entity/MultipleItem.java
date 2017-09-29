package ren.yale.android.androidbaseframe.ui.test.brvah.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by yale on 2017/9/29.
 */

public class MultipleItem implements MultiItemEntity {
    public static final int TEXT = 0;
    public static final int IMG = 1;
    private int itemType;
    private int value;

    public MultipleItem(int itemType) {
        this.itemType = itemType;
    }
    public void setValue(int v){
        value =v;
    }
    public int getValue(){
        return value;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}