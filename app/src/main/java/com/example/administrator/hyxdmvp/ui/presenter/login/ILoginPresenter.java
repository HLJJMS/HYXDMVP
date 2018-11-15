package com.example.administrator.hyxdmvp.ui.presenter.login;

import com.example.administrator.hyxdmvp.bean.LoginBean;

public interface ILoginPresenter {
    void success(LoginBean bean);
    void fail(String s);
    void goRequest(String userName , String pws );
    void onDestroy();
}
