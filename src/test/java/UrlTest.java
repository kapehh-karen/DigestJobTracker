import me.kapehh.DigestJobTracker.Utils.URLUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by karen on 28.11.2016.
 */
public class UrlTest {

    @Test
    public void testUrlRemote() {
        Assert.assertEquals(URLUtil.validRemoteURL("https://www.linkedin.com/robots.txt"), true);
        Assert.assertEquals(URLUtil.validRemoteURL("https://www.linke din.com/rob ots.txt"), false);
        Assert.assertEquals(URLUtil.validRemoteURL("file:///C:/Users/karen/Desktop/info_for_task.txt"), false);
    }

    @Test
    public void testUrlLocal() {
        Assert.assertEquals(URLUtil.validLocalURL("https://www.linkedin.com/robots.txt"), false);
        Assert.assertEquals(URLUtil.validLocalURL("file:///C:/Users/karen/Desktop/info_for_task.txt"), true);
        Assert.assertEquals(URLUtil.validLocalURL("file:///C:/Use rs/karen/Desktop/info_for_ta sk.txt"), true);
        Assert.assertEquals(URLUtil.validLocalURL("fi le:///C:/Use rs/karen/Desktop/info_for_ta sk.txt"), false);
        Assert.assertEquals(URLUtil.validLocalURL("fil e:///C:/Users/karen/Desktop/info_for_task.txt"), false);
        Assert.assertEquals(URLUtil.validLocalURL("file:///etc/hosts"), true);
        Assert.assertEquals(URLUtil.validLocalURL("file:///home/karen/test.log"), true);
        Assert.assertEquals(URLUtil.validLocalURL("file:// /home/karen/test.log"), false);
    }

}
