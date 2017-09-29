package ren.yale.android.androidbaseframe.data.db;

import android.content.Context;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import ren.yale.android.androidbaseframe.data.db.entity.MyObjectBox;

/**
 * Created by yale on 2017/9/29.
 */

public class StoreRoom {
    private BoxStore mBoxStore;
    private static class Holder{
        public static final StoreRoom INSTANCE = new StoreRoom();
    }
    public static StoreRoom getInstance(){
        return Holder.INSTANCE;
    }
    public void init(Context context){
        mBoxStore =  MyObjectBox.builder().androidContext(context).build();
    }

    public <T> BigBox<T> getBox(Class cls){
        return new BigBox<T>(mBoxStore.boxFor(cls));
    }

    public class BigBox<T>{
        private Box<T> box;

        public BigBox(Box<T> b){
            box = b;
        }
        public Box<T> box() {
            return box;
        }
        public void put(T t){
            box.put(t);
        }
    }
}
