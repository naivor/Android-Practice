package com.naivor.opengltest;

import javax.microedition.khronos.opengles.GL10;

/**
 * 颜色填充矩形
 *
 * Created by tianlai on 17-4-11.
 */

public class FlatColorSquare extends Square {

    @Override
    public void draw(GL10 gl) {
        gl.glColor4f(0.5f,0.5f,1.0f,1.0f);
        super.draw(gl);
    }
}
