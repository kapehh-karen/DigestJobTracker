package me.kapehh.DigestJobTracker.Utils;

import me.kapehh.DigestJobTracker.Exceptions.MessageException;
import sun.plugin2.message.Message;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Created by karen on 02.12.2016.
 */
public class HashUtil {

    private static String calculateHash(InputStream inputStream, String strAlgo) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(strAlgo);
        byte[] buffer = new byte[1024 * 4];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            md.update(buffer, 0, bytesRead);
        }
        inputStream.close();

        byte[] hashBytes = md.digest();
        Formatter formatter = new Formatter();
        for (byte b : hashBytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static String calculateRemoteHash(String strUrl, String strAlgo)
            throws IOException, NoSuchAlgorithmException {
        URL url = new URL(strUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // return hash from input content
            return calculateHash(httpConn.getInputStream(), strAlgo);
        } else {
            throw new MessageException("HTTP Response code is not 200: CODE = " + responseCode);
        }
    }

    public static String calculateLocalHash(String strUrl, String strAlgo)
            throws URISyntaxException, NoSuchAlgorithmException, IOException {
        File localFile = new File(new URL(strUrl).toURI());

        if (localFile.exists()) {
            // return hash from local file
            return calculateHash(new FileInputStream(localFile), strAlgo);
        } else {
            throw new MessageException("Local file not found!");
        }
    }
}
