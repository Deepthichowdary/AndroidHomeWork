package com.example.talla_000.androidhomework;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

/**
 * Created by talla_000 on 1/5/2015.
 */
public class ListViewActivityTest extends ActivityUnitTestCase<ListViewActivity> {
    private ListViewActivity mMyTestActivity;
    private Intent mLaunchIntent;

    public ListViewActivityTest() {
        super(ListViewActivity.class);
    }
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mMyTestActivity = getActivity();
        mLaunchIntent = new Intent(getInstrumentation()
                .getTargetContext(), MyActivity.class);
        mLaunchIntent.putExtra("Index",1);
        startActivity(mLaunchIntent, null, null);
    }
}
