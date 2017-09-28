package ren.yale.android.androidbaseframe.common;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yale on 2017/9/28.
 */

public class ImageLoader {
    private Context mContext;

    private static class Holder{
        public static final ImageLoader INSTANCE = new ImageLoader();
    }

    public static ImageLoader getInstance(){
        return Holder.INSTANCE;
    }

    public void init(Context context){
        mContext = context.getApplicationContext();
    }

    public void load(String url, ImageView view){
        Glide.with(mContext).load(url)
                .into(view);
    }


}
