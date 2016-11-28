package me.kapehh.DigestJobTracker.Utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by karen on 28.11.2016.
 */
public class ExceptionUtil {

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }
}
