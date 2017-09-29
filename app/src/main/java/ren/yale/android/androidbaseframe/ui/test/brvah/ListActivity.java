package ren.yale.android.androidbaseframe.ui.test.brvah;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.oushangfeng.pinnedsectionitemdecoration.PinnedHeaderItemDecoration;

import java.util.ArrayList;
import java.util.List;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.Navigate;
import ren.yale.android.androidbaseframe.ui.BaseSimpleActivity;
import ren.yale.android.androidbaseframe.ui.test.brvah.adapter.ListAdapter;
import ren.yale.android.androidbaseframe.ui.test.brvah.adapter.MultipleItemQuickAdapter;
import ren.yale.android.androidbaseframe.ui.test.brvah.entity.MultipleItem;
import ren.yale.android.androidbaseframe.ui.test.brvah.entity.TestItem;

@Route(path = Navigate.PATH.List)
public class ListActivity extends BaseSimpleActivity {
    RecyclerView recyclerView;
    int mToolBarHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_list);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        //toolbar.setBackgroundColor(Color.BLUE);
        getSupportActionBar().setTitle("list");
       // toolbar.getBackground().mutate().setAlpha(200);
        recyclerView  = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {



                int off = recyclerView.computeVerticalScrollOffset();

                float alpha = (float) off/mToolBarHeight;;

                if (mToolBarHeight == 0||off==0){
                    return;
                }
                int alp = (int)(alpha*255);
                Log.d("list",alp+" "+mToolBarHeight+" "+off );
                toolbar.setAlpha(1-alpha);
                if (alp>255){
                    alp = 255;
                }

               // toolbar.getBackground().setAlpha(255-alp);
                //float alpha = scale * 255;
                //toolbar.setBackgroundColor(Color.argb((int) alpha* 255, 128, 0, 0));

                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        toolbar.post(new Runnable() {
            @Override
            public void run() {
                mToolBarHeight = toolbar.getMeasuredHeight();

            }
        });
        linearLayout();
    }

    private void linearLayout(){
        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ListAdapter listAdapter = new ListAdapter(R.layout.test_list_item,getData());
        listAdapter.openLoadAnimation();
        recyclerView.setAdapter(listAdapter);
        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }
    private void gridLayout(){
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ListAdapter listAdapter = new ListAdapter(R.layout.test_list_item,getData());
        listAdapter.openLoadAnimation();
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    private void staggerGridLayout(){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ListAdapter listAdapter = new ListAdapter(R.layout.test_list_item,getData());
        listAdapter.openLoadAnimation();

        recyclerView.addItemDecoration(new PinnedHeaderItemDecoration.Builder(MultipleItem.TEXT).setDividerId(R.drawable.divider).enableDivider(true)
                .create());
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }
    private void mutiLinerLayout(){
        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MultipleItemQuickAdapter listAdapter = new MultipleItemQuickAdapter(getMutilData());
        listAdapter.openLoadAnimation();

        recyclerView.addItemDecoration(new PinnedHeaderItemDecoration.Builder(MultipleItem.TEXT).setDividerId(R.drawable.divider).enableDivider(true)
                .create());

        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.linnear_layout:
                linearLayout();
                break;
            case R.id.grid_layout:
                gridLayout();
                break;
            case R.id.multi_layout:
                mutiLinerLayout();
                break;
            case R.id.staggered_grid_layout:
                staggerGridLayout();
                break;


        }

        return super.onOptionsItemSelected(item);
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
    private List getMutilData(){
        List<MultipleItem> list = new ArrayList<>();

        for (int i = 0 ;i<50;i++){

            MultipleItem testItem = new MultipleItem(i%2);
            testItem.setValue(i);
            list.add(testItem);
        }
        return list;
    }
}
