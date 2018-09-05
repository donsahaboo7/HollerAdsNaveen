package com.a2zdevelopers.hollerads;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    Toolbar toolbar;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar = findViewById(R.id.webtoolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt(FunctionRecyclerAdapter.POSITION_NO);
        Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();


        webView = findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        loadURL();


    }

    private void loadURL() {
        switch (position) {
            case 0:
                webView.loadUrl("https://www.facebook.com/");
                break;
            case 1:
                webView.loadUrl("https://www.google.com");
                break;


        }
        webView.setWebViewClient(new WebViewController());
    }

    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
