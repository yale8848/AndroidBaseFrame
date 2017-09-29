package ren.yale.android.androidbaseframe.common;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;

import com.allenliu.badgeview.BadgeFactory;
import com.allenliu.badgeview.BadgeView;

/**
 * Created by yale on 2017/9/29.
 */

public class BadgeViewDisplay {


    public static void show(Context context,View view){
        BadgeFactory.create(context)
                .setTextColor(Color.WHITE)
                .setWidthAndHeight(11,11)
                .setBadgeBackground(Color.RED)
                //.setTextSize(10)
                .setBadgeGravity(Gravity.RIGHT|Gravity.TOP)
                .setBadgeCount(20)
                .setShape(BadgeView.SHAPE_CIRCLE)
                .bind(view);
    }
}
