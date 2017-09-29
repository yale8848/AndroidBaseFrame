package ren.yale.android.androidbaseframe.ui.test.index;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ren.yale.android.androidbaseframe.R;
import ren.yale.android.androidbaseframe.common.Navigate;
import ren.yale.android.androidbaseframe.data.db.StoreRoom;
import ren.yale.android.androidbaseframe.data.db.entity.StudentEntity;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_index);


    }
    private void  add(){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAge(22);
        studentEntity.setName("aaa");
        StoreRoom.getInstance().getBox(StudentEntity.class).put(studentEntity);
    }

    public void onClick(View view){
        Navigate.path(Navigate.PATH.Test).navigation();
    }
    public void onClickList(View v){
        Navigate.path(Navigate.PATH.List).navigation();
    }
    public void onClickRecycleWebview(View v){
        Navigate.path(Navigate.PATH.RecyclerWebview).navigation();
    }
    public void onClickRecycleWebviewEvent(View v){
        Navigate.path(Navigate.PATH.RecyclerWebviewEvent).navigation();
    }
}
