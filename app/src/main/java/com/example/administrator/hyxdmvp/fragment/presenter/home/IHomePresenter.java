package com.example.administrator.hyxdmvp.fragment.presenter.home;

import com.example.administrator.hyxdmvp.base.BaseOkHttp;

public interface IHomePresenter {
    void onDestroy();
    void getProjectPlan(String url, BaseOkHttp okHttp);
}
