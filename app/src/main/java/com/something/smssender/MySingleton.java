package com.something.smssender;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {


    private  static  MySingleton mInstance;
    private RequestQueue requestQueue;
    private  static Context mctx;

    private  MySingleton(Context context){
        mctx = context;
        requestQueue = getRequestQueue();
    }

    public  static  synchronized  MySingleton getInstance(Context context ){
        if(mInstance==null){
            mInstance = new MySingleton(context);

        }
        return  mInstance;
    }

    public  RequestQueue getRequestQueue(){
        if(requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(mctx.getApplicationContext());

        }
        return  requestQueue;
    }

    public <T>void  addtoRequestQueue(Request<T> request){
        requestQueue.add(request);

    }
}
