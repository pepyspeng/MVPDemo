package com.mvpdemo.listener;

import java.util.HashMap;

/**
 * Created by pepyspeng on 2017/2/25.
 */
public interface CallbackListener {

    void before();

    /**
     * 感觉使用map的话更加通用
     * @param hashMap
     */
    void onSuccess(HashMap hashMap);
    void onFailure(HashMap hashMap);
    void after();

}
