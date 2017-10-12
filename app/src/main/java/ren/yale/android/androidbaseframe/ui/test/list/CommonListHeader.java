package ren.yale.android.androidbaseframe.ui.test.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

import ren.yale.android.androidbaseframe.R;

import static ren.yale.android.baseutilslib.SizeUtils.dp2px;

/**
 * Created by yale on 2017/10/12.
 */

public class CommonListHeader extends LinearLayout implements RefreshHeader {

    private Context mContext;
    private LinearLayout mRoot;
    private ImageView mImageViewNormal;
    private ImageView mImageViewFly;
    private int HEADER_HEIGHT_DP = 80;
    private int FLY_WIDTH_DP = 80;
    private int mHeaderHeight ;

    public CommonListHeader(Context context) {
        super(context);
        init(context);
    }

    public CommonListHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CommonListHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mContext = context;
        mRoot = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.test_dxh_listview_header_view,null);
        mImageViewNormal = (ImageView) mRoot.findViewById(R.id.iv_normal);
        mImageViewFly = (ImageView) mRoot.findViewById(R.id.iv_fly);
        mHeaderHeight =dp2px(context,HEADER_HEIGHT_DP);
        scaleFlyImageView(context);
        LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,mHeaderHeight);
        this.addView(mRoot,layoutParams);
    }
    private void scaleFlyImageView(Context context){

        Drawable d = context.getResources().getDrawable(R.drawable.spinner_fly0001);
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        int w = dp2px(context,FLY_WIDTH_DP);
        int h = w*bitmap.getHeight()/bitmap.getWidth();
        LinearLayout.LayoutParams layoutParams = new LayoutParams(w,h);
        mImageViewFly.setLayoutParams(layoutParams);
    }
    @Override
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {
        scale(percent);
    }
    private void scale(float scale){

        LinearLayout.LayoutParams layoutParams = (LayoutParams) mImageViewNormal.getLayoutParams();
        if(scale>1.0){
            scale = 1.0f;
        }
        layoutParams.width = (int) (mHeaderHeight*scale);
        layoutParams.height = (int) (mHeaderHeight*scale);
        mImageViewNormal.setLayoutParams(layoutParams);
    }
    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {

    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(@ColorInt int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {
        mImageViewNormal.setVisibility(View.GONE);
        mImageViewFly.setVisibility(View.VISIBLE);

        AnimationDrawable spinner = (AnimationDrawable) mImageViewFly.getBackground();
        spinner.start();
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        return 0;
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:
                mImageViewNormal.setVisibility(View.VISIBLE);
                mImageViewFly.setVisibility(View.GONE);
                AnimationDrawable spinner = (AnimationDrawable) mImageViewFly.getBackground();
                spinner.stop();
                break;
            case Refreshing:

                break;
            case ReleaseToRefresh:

                break;
        }
    }
}
