package com.liuzhao.onroad.activity;

import android.os.Bundle;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.common.IntentConstants;

import org.xutils.view.annotation.ViewInject;

public class WeiXinDetailActivity extends BaseActivity {
    @ViewInject(R.id.webView)
    private WebView webView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_xin_detail);
        webView.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        Bundle bundle = getIntent().getExtras();
        url = bundle.getString(IntentConstants.URL, "");
        webView.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {

        }

        @Override
        public void onReceivedHttpAuthRequest(WebView view,
                                              HttpAuthHandler handler, String host, String realm) {

        }
    }

}
