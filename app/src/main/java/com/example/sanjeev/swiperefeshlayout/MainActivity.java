package com.example.sanjeev.swiperefeshlayout;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    WebView webView;
    WebViewClient webViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=(WebView)findViewById(R.id.webView_id);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefreshActivity);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        });
        webView.loadUrl("http://www.google.com");
        webViewClient=new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                //super.onPageFinished(view, url);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                //super.onLoadResource(view, url);

            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                //super.onPageCommitVisible(view, url);
                swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
            }
        };
        webView.setWebViewClient(webViewClient);
    }
}
