package com.naivor.opengltest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * 颜色平滑过渡的矩形
 *
 * Created by tianlai on 17-4-11.
 */

public class SmoothColorSquare extends Square {

    float[] colors = {
            1f, 0f, 0f, 1f,
            0f, 1f, 0f, 1f,
            0f, 0f, 1f, 1f,
            1f, 0f, 1f, 1f
    };

   protected FloatBuffer colorsfb;

    public SmoothColorSquare() {
        super();

        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        colorsfb = cbb.asFloatBuffer();
        colorsfb.put(colors);
        colorsfb.position(0);

    }

    @Override
    public void draw(GL10 gl) {
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,vertexBuf);

        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glColorPointer(4,GL10.GL_FLOAT,0,colorsfb);

        super.draw(gl);

        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
