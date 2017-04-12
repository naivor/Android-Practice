package com.naivor.jsbridge;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianlai on 17-4-12.
 */

public class JSBridge {
    private static Map<String, Map<String, Method>> exposedMethods = new HashMap<>();

    public static void register(String exposedName, Class<? extends IBridge> clazz) {
        Log.i("JSBridge", "register 被调用");

        if (!exposedMethods.containsKey(exposedName)) {
            try {
                exposedMethods.put(exposedName, getAllMethod(clazz));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Map<String, Method> getAllMethod(Class injectedCls) throws Exception {
        Log.i("JSBridge", "getAllMethod 被调用");

        HashMap mMethodMap = new HashMap();
        Method[] methods = injectedCls.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (method.getModifiers() != (Modifier.PUBLIC | Modifier.STATIC) || (null == name)) {
                continue;
            }

            Class[] parameters = method.getParameterTypes();
            if (parameters != null && parameters.length == 3) {
                if (parameters[0] == WebView.class && parameters[1] == JSONObject.class && parameters[2] == Callback.class) {
                    mMethodMap.put(name, method);
                }
            }
        }

        return mMethodMap;
    }

    public static String callJava(WebView webView, String uriString) {
        String methodName = "";
        String className = "";
        String param = "";
        String port = "";

        Log.i("JSBridge", "callJava 被调用:"+uriString);

        if (!TextUtils.isEmpty(uriString) && uriString.startsWith("JSBridge")) {
            Uri uri = Uri.parse(uriString);
            className = uri.getHost();
            param = uri.getQuery();
            port = uri.getPort() + "";

            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                methodName = path.replace("/", "");
            }
        }

        if (exposedMethods.containsKey(className)) {
            Map<String, Method> methods = exposedMethods.get(className);

            if (methods != null && methods.size() != 0 && methods.containsKey(methodName)) {
                Method method = methods.get(methodName);
                if (method != null) {
                    try {
                        Log.i("JSBridge", "method.invoke");
                        method.invoke(null, webView, new JSONObject(param), new Callback(webView, port));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return null;
    }
}
