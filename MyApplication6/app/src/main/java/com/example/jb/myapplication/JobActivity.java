package com.example.jb.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JobActivity extends AppCompatActivity {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        webView=(WebView)findViewById(R.id.WebJob);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://mm.jora.com/Network-Engineer-jobs-in-Myanmar?utm_campaign=dynamic&utm_source=google&utm_medium=cpc&gclid=Cj0KCQiA3IPgBRCAARIsABb-iGJhWrK4PzC8jNEBNfhufigMO7aRcUfxn_TsDWXobEL9Ea8rC0m5F1waAlyvEALw_wcB");
         webView.setWebViewClient(new MyWebViewClient());
        ;
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }

    }


    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().equals("https://mm.jora.com/Network-Engineer-jobs-in-Myanmar?utm_campaign=dynamic&utm_source=google&utm_medium=cpc&gclid=Cj0KCQiA3IPgBRCAARIsABb-iGJhWrK4PzC8jNEBNfhufigMO7aRcUfxn_TsDWXobEL9Ea8rC0m5F1waAlyvEALw_wcB"))
            {
                return false;
            }
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }
}
