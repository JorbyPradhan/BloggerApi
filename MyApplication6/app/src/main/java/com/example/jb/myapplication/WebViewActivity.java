package com.example.jb.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
         web=(WebView)findViewById(R.id.Web);
        web.loadUrl("https://www.youtube.com/user/RHCTechnologies");
        WebSettings webSetting=web.getSettings();
        webSetting.setJavaScriptEnabled(true);
        web.setWebViewClient(new MyViewClient());
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
    private class MyViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().equals("https://www.youtube.com/user/RHCTechnologies"))
            {
                return false;
            }
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }
}
