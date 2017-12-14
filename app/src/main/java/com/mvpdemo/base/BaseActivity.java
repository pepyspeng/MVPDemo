package com.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by pepyspeng on 2017/2/25.
 */

public abstract class BaseActivity<V,T extends IBaseContract.Presenter<V>> extends FragmentActivity {

    protected T mPresneter ;
    /**
     * create presenter
     * @return
     */
    protected abstract T createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*创建Presenter*/
        mPresneter = createPresenter();
        /*内存泄漏 ， 关联View*/
        mPresneter.attachView((V) this);
        setContentView(getLayoutID());
        findViewByID();
    }

    protected abstract int getLayoutID();
    protected abstract void findViewByID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresneter.onDestroy();
    }
}
