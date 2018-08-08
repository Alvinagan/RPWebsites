package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView wvPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wvPage = findViewById(R.id.webViewPage);

        wvPage.setWebViewClient(new WebViewClient());
        wvPage.getSettings().setJavaScriptEnabled(true);
        wvPage.getSettings().setAllowFileAccess(false);
        wvPage.getSettings().setBuiltInZoomControls(true);

        Intent intentReceive = getIntent();
        String url = intentReceive.getStringExtra("url");
        wvPage.loadUrl(url);
    }
}

