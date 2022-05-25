package com.baidu.evs;


import com.mvpdemo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class EvsMainActivity extends AppCompatActivity {

    private static final String TAG = "EvsMainActivity";
    static {
        try {
            Log.d(TAG, "---------------load start ");
//            System.loadLibrary("locSDK8a");
//            Log.d(TAG, "---------------load success locSDK8a  ");
            System.loadLibrary("evs_app");
            Log.d(TAG, "---------------load success evs_app: ");
        } catch (Throwable t) {
            t.printStackTrace();
            Log.d(TAG, "---------------load err: "+ t.getMessage());
        }
    }

    public static native void startEVS();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evs_main);
        findViewById(R.id.btn_startEvs).setOnClickListener(v -> {
            Log.e(TAG,"call java stack",new RuntimeException());
//            startEVS();
        });
    }
}
