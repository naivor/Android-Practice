package com.naivor.opengltest;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        GLSurfaceView view = new GLSurfaceView(getApplicationContext());
        view.setRenderer(new OpenGLRender());

        setContentView(view);
    }
}
