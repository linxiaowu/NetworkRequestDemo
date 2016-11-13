package cn.xiaowu.networkrequestdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Calendar;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {

    String API = "http://apis.baidu.com/avatardata/historytoday/lookup";

    TextView responseTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        responseTextView = (TextView) findViewById(R.id.responseTextView);


        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);


        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("yue", "" + month).
                        add("ri", "" + day).
                        add("type", "" + 1).
                        add("page", "" + 1).
                        add("rows", "" + 10).
                        add("dtype", "JSON").build();


        Request request = new Request.Builder()
                .url(API)
                .addHeader("apikey", "fbfe816c92fdafcdb960cfef4f8c9bcc")
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Gson gson = new Gson();

                final HistoryTodayBean data = gson.fromJson(response.body().string(), HistoryTodayBean.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String text = "";
                        for (HistoryTodayBean.ResultEntity resultEntity : data.getResult()) {
                            text = text + resultEntity.getTitle() + " \n ";
                        }
                        responseTextView.setText(text);
                    }
                });
            }
        });

    }


}
