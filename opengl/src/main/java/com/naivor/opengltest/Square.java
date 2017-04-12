package com.naivor.opengltest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * 矩形
 *
 * Created by tianlai on 17-4-11.
 */

public class Square {

    protected float vertices[] = {
            -1.0f, 1.0f, 0.0f,  //0
            -1.0f, -1.0f, 0.0f,  //1
            1.0f, -1.0f, 0.0f,   //2
            1.0f, 1.0f, 0.0f  //3
    };

    protected short[] indices = {0, 1, 2, 0, 2, 3};

    protected FloatBuffer vertexBuf;

    protected ShortBuffer indexBuf;

    public Square() {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());

        vertexBuf = vbb.asFloatBuffer();
        vertexBuf.put(vertices);
        vertexBuf.position(0);

        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
        ibb.order(ByteOrder.nativeOrder());

        indexBuf = ibb.asShortBuffer();
        indexBuf.put(indices);
        indexBuf.position(0);
    }

    public void draw(GL10 gl){
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,vertexBuf);

        gl.glDrawElements(GL10.GL_TRIANGLES,indices.length,GL10.GL_UNSIGNED_SHORT,indexBuf);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }
}
