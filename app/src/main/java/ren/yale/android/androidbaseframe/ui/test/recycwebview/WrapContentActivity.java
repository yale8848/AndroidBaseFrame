package ren.yale.android.androidbaseframe.ui.test.recycwebview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.Navigate;


/**
 * Created by 小爱 on 2017/7/25.
 */
@Route(path = Navigate.PATH.RecyclerWebview)
public class WrapContentActivity extends AppCompatActivity {

    private static final String TAG = "SlideConfictActivity";
    private static final int ITEM_TYPE_TEXT_VIEW = 1;
    private static final int ITEM_TYPE_WEB_VIEW = 2;
    private static final int ITEM_VIEW_COUNT = 10;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_recyclerview);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter {

        private WebViewHolder webViewHolder;

        public WebViewHolder getWebViewHolder() {
            return webViewHolder;
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            if(viewType == ITEM_TYPE_TEXT_VIEW) {
                return new TextViewHolder(inflater.inflate(R.layout.test_item_textview, parent, false));
            }
            if(webViewHolder == null) {
                webViewHolder = new WebViewHolder(inflater.inflate(R.layout.test_item_webview2, parent, false));
            }
            return webViewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof TextViewHolder) {
                ((TextViewHolder) holder).setTitle("解决方案一（wrap_content）");
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return ITEM_TYPE_WEB_VIEW;
            }
            return ITEM_TYPE_TEXT_VIEW;
        }

        @Override
        public int getItemCount() {
            return ITEM_VIEW_COUNT;
        }
    }
}
