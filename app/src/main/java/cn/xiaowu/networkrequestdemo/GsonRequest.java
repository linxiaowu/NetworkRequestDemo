package cn.xiaowu.networkrequestdemo;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by linxiaowu on 2016/11/7.
 * Gson Request
 */
public class GsonRequest<T> extends Request<T> {

    private final Response.Listener<T> mListener;

    private Gson mGson;

    private Class<T> mClass;
    private Map<String, String> header;
    private Map<String, String> params;


    public GsonRequest(int method,
                       String url,
                       Class<T> clazz,
                       Map<String, String> head,
                       Map<String, String> params,
                       Response.Listener<T> mListener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = mListener;
        this.header = head;
        this.params = params;
        this.mClass = clazz;

        mGson = new Gson();

    }

    public GsonRequest(String url,
                       Class<T> clazz,
                       Map<String, String> head,
                       Map<String, String> params,
                       Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        this(Method.GET, url, clazz, head, params, listener, errorListener);
    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(mGson.fromJson(jsonString, mClass), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (header == null) return super.getHeaders();
        else return header;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        if (params == null) return super.getParams();
        return params;
    }
}
