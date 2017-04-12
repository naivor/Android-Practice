package com.naivor.jsbridge;

import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tianlai on 17-4-12.
 */

public class BridgeImpl implements IBridge {

    public static void showToast(WebView view, JSONObject params, Callback callback) {
        Log.i("BridgeImpl", "showToast 被调用");

        String message = params.optString("msg");
        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        if (callback != null) {
            try {
                JSONObject object = new JSONObject();
                object.put("key", "value");
                callback.apply(getJSONObject(0, "ok", object));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static JSONObject getJSONObject(int code, String msg, JSONObject result) {
        Log.i("BridgeImpl", "getJSONObject 被调用");

        try {
            JSONObject object = new JSONObject();
            object.put("code", code);
            object.put("msg", msg);
            object.putOpt("result", result);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
