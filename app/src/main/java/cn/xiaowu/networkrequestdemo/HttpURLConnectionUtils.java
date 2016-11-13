package cn.xiaowu.networkrequestdemo;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by linxiaowu on 2016/11/1.
 * HttpURLConnection
 */
class HttpURLConnectionUtils {

    private final static String TAG = HttpURLConnectionUtils.class.getName();

    static String postRequest(String path, String content) {
        try {
            URL url = new URL(path);

            //创建连接
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST"); //设置为post请求
            httpURLConnection.setReadTimeout(5000); //设置读取5秒超时
            httpURLConnection.setConnectTimeout(10000); //设置连接10秒超时
            httpURLConnection.setDoOutput(true);


            //post请求参数
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(content.getBytes());
            out.flush();
            out.close();

            int responseCode = httpURLConnection.getResponseCode();
            Log.d(TAG, "responseCode : " + responseCode);

            //返回200成功
            if (responseCode == 200) {

                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                inputStream.close();
                String response = byteArrayOutputStream.toString();
                byteArrayOutputStream.close();

                Log.d(TAG, "response : " + response);

                return response;
            }
        } catch (IOException e) {
            Log.d(TAG, "error : " + e);
        }
        return "error";
    }


}
