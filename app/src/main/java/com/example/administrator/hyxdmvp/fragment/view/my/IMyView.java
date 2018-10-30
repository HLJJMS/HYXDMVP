package com.example.administrator.hyxdmvp.fragment.view.my;

import com.example.administrator.hyxdmvp.bean.UserDataBean;

public interface IMyView {
    void showToast(String message);
    void getUserDataCallBack(UserDataBean bean);

}
