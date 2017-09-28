package ren.yale.android.androidbaseframe.ui.brvah.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.ImageLoader;
import ren.yale.android.androidbaseframe.data.bean.TestItem;

/**
 * Created by yale on 2017/9/28.
 */

public class ListAdapter extends BaseQuickAdapter<TestItem, BaseViewHolder> {

    public ListAdapter(@LayoutRes int layoutResId, @Nullable List<TestItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestItem item) {
        helper.setText(R.id.tv_name,item.name);
        ImageLoader.getInstance().load(item.img, (ImageView) helper.getView(R.id.image));
    }
}
