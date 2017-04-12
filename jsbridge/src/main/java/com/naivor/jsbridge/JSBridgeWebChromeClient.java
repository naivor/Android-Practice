package com.naivor.jsbridge;

import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by tianlai on 17-4-12.
 */

public class JSBridgeWebChromeClient extends WebChromeClient {

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Log.i("JSBridgeWebChromeClient", "onJsAlert 被调用");
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        Log.i("JSBridgeWebChromeClient", "onJsConfirm 被调用");
        return super.onJsConfirm(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Log.i("JSBridgeWebChromeClient", "onJsPrompt 被调用");
        result.confirm(JSBridge.callJava(view, message));
        return true;
    }
}
