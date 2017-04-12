package com.naivor.jsbridge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.wv_test)
    WebView wvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        wvTest.setWebChromeClient(new JSBridgeWebChromeClient());

        JSBridge.register("bridge", BridgeImpl.class);

        wvTest.getSettings().setJavaScriptEnabled(true);

        wvTest.loadUrl("file:///android_asset/test_jsbridge.html");
    }
}
