package com.example.talla_000.androidhomework;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by talla_000 on 1/5/2015.
 */
public class MyActivityTest extends ActivityUnitTestCase<MyActivity> {
    private MyActivity mMyTestActivity;
    private Intent mLaunchIntent;

    public MyActivityTest() {
        super(MyActivity.class);
    }
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mMyTestActivity = getActivity();
        mLaunchIntent = new Intent(getInstrumentation()
                .getTargetContext(), MyActivity.class);
        startActivity(mLaunchIntent, null, null);

    }
    @SmallTest
    public void testButtonViewNotNull(){
        Button b1=(Button) mMyTestActivity.findViewById(R.id.button1);
        Button b2=(Button) mMyTestActivity.findViewById(R.id.button2);
        assertNotNull(b1);
        assertNotNull(b2);
    }
    public void testPreconditions() {
        assertNotNull("mTestActivity is null", mMyTestActivity);

    }
    @MediumTest
    public void testNextActivityWasLaunchedWithIntent() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton =
                (Button) getActivity()
                        .findViewById(R.id.button1);
        launchNextButton.performClick();

        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull("Intent was null", launchIntent);
        assertTrue(isFinishCalled());
    }

}
