package com.naivor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tianlai on 17-4-17.
 */
public class CaculatorTest {

    Caculator caculator;

    @Before
    public void setUp() {
        caculator = new Caculator();
    }

    @Test
    public void add() throws Exception {
        int result = caculator.add(1, 2);

        Assert.assertEquals(3, result);
    }

    @After
    public void tearDown() {
        caculator = null;
    }
}