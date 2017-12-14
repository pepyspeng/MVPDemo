package com.mvpdemo.business.login.contract.presneter;

import com.mvpdemo.base.BasePresenterImpl;
import com.mvpdemo.listener.CallbackListener;
import com.mvpdemo.business.login.contract.ILoginContract;
import com.mvpdemo.data.model.LoginModelImpl;

import java.util.HashMap;

/**
 * Created by pepys on 2017/5/26.
 * description:Presneter 这是是处理view和model的地方
 */
public class LoginPresneterImpl extends BasePresenterImpl implements ILoginContract.Presenter {

    /**
     * 持有view引用
     */
    private ILoginContract.View view;
    /**
     * 持有model引用
     */
    private ILoginContract.Model model = new LoginModelImpl();

    public LoginPresneterImpl(ILoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login() {
        model.login(view.getName(), view.getPassword(), new CallbackListener() {
            @Override
            public void before() {
                view.showProgress();
            }

            @Override
            public void onSuccess(HashMap hashMap) {
                view.loginSuccess();
            }

            @Override
            public void onFailure(HashMap hashMap) {
                view.loginFailure();
            }

            @Override
            public void after() {
                view.hideProgress();
            }
        });
    }

    @Override
    public void onStart() {
        //这里可以放入进界面就请求的
    }
}
