package me.kapehh.DigestJobTracker.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Created by karen on 02.12.2016.
 */
public class HashUtil {

    public static String calculateRemoteHash(String strUrl, String strAlgo) throws IOException, NoSuchAlgorithmException {
        URL url = new URL(strUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read content
            InputStream inputStream = httpConn.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int bytesRead;
            byte[] buffer = new byte[1024 * 4];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();

            // Hashing
            MessageDigest md = MessageDigest.getInstance(strAlgo);
            byte[] hashBytes = md.digest(outputStream.toByteArray());
            Formatter formatter = new Formatter();
            for (byte b : hashBytes) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        }

        return null;
    }
}
