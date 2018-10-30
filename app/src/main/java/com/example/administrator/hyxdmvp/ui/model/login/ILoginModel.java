package com.example.administrator.hyxdmvp.ui.model.login;

import com.example.administrator.hyxdmvp.ui.presenter.login.ILoginPresenter;

public interface ILoginModel {
    void GetDate(String userName, String pws, final ILoginPresenter presenter);
}
