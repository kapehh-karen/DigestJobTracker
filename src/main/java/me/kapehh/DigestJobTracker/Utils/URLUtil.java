package me.kapehh.DigestJobTracker.Utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * Created by karen on 28.11.2016.
 */
public class URLUtil {
    private static Pattern patternRemoteUrl =
            Pattern.compile("^(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!10(?:\\.\\d{1,3}){3})(?!127(?:\\.\\d{1,3}){3})(?!169\\.254(?:\\.\\d{1,3}){2})(?!192\\.168(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)*(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}]{2,})))(?::\\d{2,5})?(?:/[^\\s]*)?$");
    private static Pattern patternLocalUrl =
            Pattern.compile("^file://(/[a-zA-Z]:)?(/[ a-zA-Z0-9_.-]+)+/?$");

    public static boolean validRemoteURL(String urlName){
        return patternRemoteUrl.matcher(urlName).find();
    }

    public static boolean validLocalURL(String urlName){
        return patternLocalUrl.matcher(urlName).find();
    }
}
