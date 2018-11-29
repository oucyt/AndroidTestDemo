package cn.fortrun.androidtestdemo.test.groupshare;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import cn.fortrun.androidtestdemo.groupshare.CheckoutActivity;
import cn.fortrun.androidtestdemo.groupshare.DataLoadedEvent;

/**
 * Created by xiaochuang on 4/25/16.
 */
@RunWith(RobolectricTestRunner.class)
public class CheckoutActivityTest {

    private CheckoutActivity mActivity;

    @Before
    public void setup() {
        mActivity = Robolectric.setupActivity(CheckoutActivity.class);
    }

    @Test
    @JSpec(desc = "should call CheckoutModel.loadCheckoutData when activity starts")
    public void testActivityStarts() {
        //Verify that mCheckoutData's loadCheckoutData method is called
    }

    @Test
    public void testOnDataLoadedEvent_success() throws Exception {
        DataLoadedEvent event = new DataLoadedEvent(new Object());
        mActivity.onDataLoadedEvent(event);

        //Verify view updated correctly
    }

    @Test
    public void testOnDataLoadedEvent_failure() throws Exception {
        DataLoadedEvent event = new DataLoadedEvent(500, "Server error");
        mActivity.onDataLoadedEvent(event);

        //Verify error message shown
    }
}