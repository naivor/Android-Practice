package com.tianlai.mocktest;

import android.util.Log;

/**
 * Created by tianlai on 17-4-17.
 */

public class Repo {


    public void optData(int id, String name) {
        Log.i("详情", "id:" + id + "-name:" + name);
    }


    public void optError(int id, String name) {
        Log.i("详情", "id:" + id + "-name:" + name);
    }
}
