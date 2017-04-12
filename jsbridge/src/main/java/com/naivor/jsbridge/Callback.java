package com.naivor.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

import org.json.JSONObject;

import java.lang.ref.WeakReference;

/**
 * Created by tianlai on 17-4-12.
 */

public class Callback {
    private static Handler handler=new Handler(Looper.getMainLooper());
    private static final String CALLBACK_JS_FORMAT="javascript:JSBridge.onFinish('%s',%s);";
    private String port;
    private WeakReference<WebView> webViewWeak;

    public Callback(WebView webView,String port) {
        this.port = port;
        webViewWeak=new WeakReference<WebView>(webView);
    }

    public void apply(JSONObject jsonObject){
        final String execJs=String.format(CALLBACK_JS_FORMAT,port,String.valueOf(jsonObject));
        if (webViewWeak!=null&&webViewWeak.get()!=null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    webViewWeak.get().loadUrl(execJs);
                }
            });
        }
    }
}
