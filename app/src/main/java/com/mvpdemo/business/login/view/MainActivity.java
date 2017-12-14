package com.mvpdemo.business.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvpdemo.R;
import com.mvpdemo.base.BaseActivity;
import com.mvpdemo.base.IBaseContract;
import com.mvpdemo.business.login.contract.ILoginContract;
import com.mvpdemo.business.login.contract.presneter.LoginPresneterImpl;

/**
 * Created by pepys on 2017/2/27.
 * description:
 */
public class MainActivity extends BaseActivity<ILoginContract.View,IBaseContract.Presenter<ILoginContract.View>> implements ILoginContract.View,View.OnClickListener{

    private LoginPresneterImpl presneter ;
    private EditText logion_name,logion_pwd;
    private Button login_submit;
    @Override
    protected IBaseContract.Presenter<ILoginContract.View> createPresenter() {
        return presneter = new LoginPresneterImpl(MainActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViewByID() {
        logion_name = (EditText) findViewById(R.id.logion_name);
        logion_pwd = (EditText) findViewById(R.id.logion_pwd);
        login_submit = (Button) findViewById(R.id.login_submit);
        login_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_submit:
                presneter.login();
                break;
        }
    }

    @Override
    public void showProgress() {
        Toast.makeText(this,"请稍等..",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public String getName() {
        return logion_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return logion_pwd.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"成功..",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this,"失败..",Toast.LENGTH_LONG).show();
    }


}
