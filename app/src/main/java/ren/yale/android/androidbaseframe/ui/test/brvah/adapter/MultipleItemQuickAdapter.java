package ren.yale.android.androidbaseframe.ui.test.brvah.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.ui.test.brvah.entity.MultipleItem;

/**
 * Created by yale on 2017/9/29.
 */

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    public MultipleItemQuickAdapter(List data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.test_list_item_mul_text);
        addItemType(MultipleItem.IMG, R.layout.test_list_item_mul_img);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv_name, ""+item.getValue());
                break;
            case MultipleItem.IMG:
                helper.setImageResource(R.id.image, R.mipmap.ic_launcher);
                break;
        }
    }

}
