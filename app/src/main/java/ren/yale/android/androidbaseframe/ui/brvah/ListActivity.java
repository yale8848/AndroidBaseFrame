package ren.yale.android.androidbaseframe.ui.brvah;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.Navigate;
import ren.yale.android.androidbaseframe.data.bean.TestItem;
import ren.yale.android.androidbaseframe.ui.BaseSimpleActivity;
import ren.yale.android.androidbaseframe.ui.brvah.adapter.ListAdapter;

@Route(path = Navigate.PATH.List)
public class ListActivity extends BaseSimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ListAdapter listAdapter = new ListAdapter(R.layout.list_item,getData());
        listAdapter.openLoadAnimation();
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

    }
    private List getData(){
        List<TestItem> list = new ArrayList<>();

        for (int i = 0 ;i<50;i++){
            TestItem testItem = new TestItem();
            testItem.name =""+i;
            list.add(testItem);
        }
        return list;
    }
}
