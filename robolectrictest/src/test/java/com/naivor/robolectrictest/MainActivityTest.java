package com.naivor.robolectrictest;

import android.content.Intent;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

/**
 * Created by tianlai on 17-4-18.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    public void testMainActivity(){
        MainActivity mainActivity= Robolectric.setupActivity(MainActivity.class);

        mainActivity.findViewById(R.id.tv_detail).performClick();

        Intent intent =new Intent(mainActivity,DetailActivity.class);

        ShadowActivity shadowActivity= Shadows.shadowOf(mainActivity);

        Assert.assertEquals(intent,shadowActivity.getNextStartedActivity());
    }
}