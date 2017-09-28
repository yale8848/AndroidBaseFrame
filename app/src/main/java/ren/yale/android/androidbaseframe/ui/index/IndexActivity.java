package ren.yale.android.androidbaseframe.ui.index;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.Navigate;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void onClick(View view){
        Navigate.path(Navigate.PATH.Test).navigation();
    }
    public void onClickList(View v){
        Navigate.path(Navigate.PATH.List).navigation();
    }
}
