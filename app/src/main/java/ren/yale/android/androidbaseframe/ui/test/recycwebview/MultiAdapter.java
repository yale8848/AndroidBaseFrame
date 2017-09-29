package ren.yale.android.androidbaseframe.ui.test.recycwebview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import ren.yale.android.androidbaseframe.R;


/**
 * Created by yale on 2017/9/29.
 */

public class MultiAdapter extends BaseMultiItemQuickAdapter<RWMutilItem, BaseViewHolder> {

    private boolean mIsLoading;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultiAdapter(List<RWMutilItem> data) {
        super(data);
        addItemType(RWMutilItem.WEBVIEW, R.layout.test_recycwebview_webview);
        addItemType(RWMutilItem.LIST, R.layout.test_recycwebview_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, RWMutilItem item) {
        switch (helper.getItemViewType()) {
            case RWMutilItem.WEBVIEW:
                WebView webView = helper.getView(R.id.webview);
                webView.setOnTouchListener(new WebViewTouchListener());

                webView.setWebViewClient(new MyWebViewClient());
                webView.setWebChromeClient(new WebChromeClient());
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                webView.loadUrl("https://m.baidu.com/from=1012852s/s?word=%E5%B7%B4%E5%8E%98%E5%B2%9B&ts=0307421&t_kt=0&ie=utf-8&fm_kl=b26a42b666&" +
                        "rsv_iqid=1090308116&rsv_t=c2dbEJhJPefAJ0vOMwixV" +
                        "WqB6iOhhVxxQLyQquz%252F5XUgPAfwO9liAVJ%252BXki86eQ&sa=is_4&rsv_pq=1090308116&rsv_sug4=10218&inputT=3904&ss=100&rq=%E5%B7%B4");
                break;
            case RWMutilItem.LIST:
                helper.setText(R.id.text,"text");
                break;
        }
    }

    private class WebViewTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return !mIsLoading;
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //判断重定向的方式一
//            WebView.HitTestResult hitTestResult = view.getHitTestResult();
//            if(hitTestResult == null) {
//                return false;
//            }
//            if(hitTestResult.getType() == WebView.HitTestResult.UNKNOWN_TYPE) {
//                return false;
//            }

            //判断重定向的方式二
            if(mIsLoading) {
                return false;
            }

            if(url != null && url.startsWith("http")) {
                view.loadUrl(url);
                return true;
            } else {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    view.getContext().startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mIsLoading = true;
            Log.d(TAG, "onPageStarted");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mIsLoading = false;
            Log.d(TAG, "onPageFinished");
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }

        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
        }
    }
}
