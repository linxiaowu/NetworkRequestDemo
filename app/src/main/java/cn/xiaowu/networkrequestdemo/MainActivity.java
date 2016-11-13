package cn.xiaowu.networkrequestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    String API = "http://182.254.228.211:9000/index.php/api/inform/index";

    String uid = "uid=26";

    private Handler handler = new Handler();
    private TextView textView;
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("点我");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final String response = HttpURLConnectionUtils.postRequest(API, uid);
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText(response);
//                    }
//                });
//            }
//        }).start();


//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, API,
//                new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                textView.setText(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> map = new HashMap<>();
//                map.put("uid",""+26);
//                return map;
//            }
//        };
//        requestQueue.add(stringRequest);


        String url = "http://apis.baidu.com/avatardata/historytoday/lookup";

        Map<String, String> header = new HashMap<>();
        header.put("apikey", "fbfe816c92fdafcdb960cfef4f8c9bcc");

        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);


        Map<String, String> params = new HashMap<>();
        params.put("yue", "" + month);
        params.put("ri", "" + day);
        params.put("type", "" + 1);
        params.put("page", "" + 1);
        params.put("rows", "" + 10);
        params.put("dtype", "JSON");


//        final RequestQueue requestQueue = Volley.newRequestQueue(this);
//        GsonRequest<HistoryTodayBean> request =
//                new GsonRequest<>(
//                        Request.Method.POST,
//                        url,
//                        HistoryTodayBean.class,
//                        header,
//                        params,
//                        new Response.Listener<HistoryTodayBean>() {
//                            @Override
//                            public void onResponse(HistoryTodayBean bean) {
//                                if (bean == null) return;
//                                if (bean.getError_code() != 0) {
//                                    Log.d(TAG, bean.getReason());
//                                    return;
//                                }
//                                if (bean.getResult() == null) return;
//
//                                String text = "";
//                                for (HistoryTodayBean.ResultEntity resultEntity : bean.getResult()) {
//                                    text = text + resultEntity.getTitle() + " \n ";
//                                }
//                                textView.setText(text);
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//        requestQueue.add(request);


    }

}
