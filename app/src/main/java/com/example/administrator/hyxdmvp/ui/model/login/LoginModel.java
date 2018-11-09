package com.example.administrator.hyxdmvp.ui.model.login;

import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.base.BaseOkHttp;
import com.example.administrator.hyxdmvp.bean.LoginBean;
import com.example.administrator.hyxdmvp.ui.presenter.login.ILoginPresenter;

public class LoginModel implements ILoginModel {
    LoginBean loginBean = new LoginBean();
    private ILoginPresenter presenter;

    @Override
    public void GetDate(String userName, String pws, final ILoginPresenter presenter) {
        BaseOkHttp<LoginBean> okHttp = new BaseOkHttp<LoginBean>(loginBean, LoginBean.class);
        this.presenter = presenter;
        okHttp.getData(AppConfig.UrlApp + AppConfig.General + "a=T50000&b=1|5&d=2::" + userName + "|3::" + pws, new BaseOkHttp.CallBack<LoginBean>() {
            @Override
            public void success(LoginBean bean) {
                presenter.success(bean);
            }

            @Override
            public void fail(String s) {
                presenter.fail(s);
            }
        });


    }


}
