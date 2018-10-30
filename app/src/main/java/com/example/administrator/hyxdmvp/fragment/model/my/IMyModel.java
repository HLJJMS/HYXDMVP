package com.example.administrator.hyxdmvp.fragment.model.my;

import com.example.administrator.hyxdmvp.fragment.presenter.my.IMyPresenter;
import com.example.administrator.hyxdmvp.fragment.presenter.my.MyPresenter;
import com.example.administrator.hyxdmvp.ui.presenter.login.ILoginPresenter;

public interface IMyModel {
    void GetUserDate(final IMyPresenter myPresenter);
}
