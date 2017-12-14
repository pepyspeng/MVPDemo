package com.mvpdemo.base;


public abstract class BasePresenterImpl<T> implements IBaseContract.Presenter<T> {

    protected T mView;


    @Override
    public void attachView( T view) {
        this.mView = view;
    }

    @Override
    public void onDestroy() {
        cancelRequest();
        mView = null;
    }

    /**
     * 这个计划是在view销毁的时候同时取消请求
     */
    public void cancelRequest() {
        //// TODO: 2017/2/25
    }

}
