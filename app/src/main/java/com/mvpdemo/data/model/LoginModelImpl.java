package com.mvpdemo.data.model;

import com.mvpdemo.listener.CallbackListener;
import com.mvpdemo.business.login.contract.ILoginContract;



/**
 * Created by pepys on 2017/5/26.
 * description: 这里才是真正的数据请求
 */
public class LoginModelImpl implements ILoginContract.Model {

    @Override
    public void login(final String name, String psw, final CallbackListener callback) {
        //模拟请求
        callback.before();
        try {
            Thread.sleep(1000*4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(name.equals("001")){
            resultMap.put("status","成功");
            callback.onSuccess(resultMap);
        }else{
            resultMap.put("status","失败");
            callback.onFailure(resultMap);
        }
        callback.after();
    }
}
