package cn.fortrun.androidtestdemo.course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;


/**
 * description
 *
 * @author tianyu
 * @create 2018.11.25 11:38
 * @since 1.0.0
 */
//@Config(manifest = "./src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
/*@Config(sdk = {JELLY_BEAN, JELLY_BEAN_MR1},
        application = CustomApplication.class,
        manifest = "--default",
        resourceDir = "some/build/path/res",
        qualifiers = "en-port"*//*限定用哪个资源values*//*)*/
//@Config(application = App.class)
public class RobolectricTest {

    @Test
    public void setup() throws Exception {
//        Activity activity = Robolectric.setupActivity(MainActivity.class);
//        TextView tv = (TextView) activity.findViewById(R.id.tv);
//        Assert.assertEquals("Hllo World!", tv.getText().toString());

    }
}
