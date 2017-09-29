package ren.yale.android.androidbaseframe.ui.test.recycwebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.Navigate;


public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        MultiAdapter multiAdapter = new MultiAdapter(getData());
        mRecyclerView.setAdapter(multiAdapter);

    }

    private List getData(){
        List<RWMutilItem> data = new ArrayList<>();

        for (int i =0;i<20;i++){
            RWMutilItem rwMutilItem;
            if (i ==0){
               rwMutilItem = new  RWMutilItem( RWMutilItem.WEBVIEW);
            }else{
                rwMutilItem = new  RWMutilItem( RWMutilItem.LIST);
            }
            data.add(rwMutilItem);
        }
        return data;
    }
}
