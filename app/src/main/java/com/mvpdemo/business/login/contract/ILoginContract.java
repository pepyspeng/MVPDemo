package com.mvpdemo.business.login.contract;

import com.mvpdemo.base.IBaseContract;
import com.mvpdemo.listener.CallbackListener;

import java.util.HashMap;

public interface ILoginContract {

    interface View extends IBaseContract.View {
        /*得到用户名*/
        String getName();
        /*得到密码*/
        String getPassword();
        void loginSuccess();
        void loginFailure();

    }

    interface Presenter extends IBaseContract.Presenter {
        /*执行请求处理*/
        void login();
    }

    interface Model {
        HashMap<String,String> resultMap = new HashMap<>();

        void login(String name, String psw, CallbackListener callback);
    }
}