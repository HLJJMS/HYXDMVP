package com.example.administrator.hyxdmvp.ui.presenter.login;

import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.bean.LoginBean;
import com.example.administrator.hyxdmvp.ui.model.login.LoginModel;
import com.example.administrator.hyxdmvp.ui.view.login.ILoginView;
import com.example.administrator.hyxdmvp.ui.view.login.LoginActivity;

public class LoginPresenter implements ILoginPresenter {
    private LoginModel model = new LoginModel();
    private ILoginView view;

    public LoginPresenter(LoginActivity view) {
        this.view = view;
    }

    @Override
    public void success(LoginBean bean) {
        if (bean.getCode().equals("0")) {
            if (null != bean.getMyDynamicData()) {
                AppConfig.CPCode = bean.getMyDynamicData().get(0).getF0001();
                AppConfig.Id = bean.getMyDynamicData().get(0).getF0005();
                view.showToast("登陆成功");
                view.successLogin();
            } else {
                view.showToast("用户名密码错误");
            }
        } else {
            view.showToast("登陆失败");
        }
//        if(null==bean){
//            view.showToast("登陆失败");
//        }else if(null!=bean.getMyDynamicData()){
//            AppConfig.CPCode = bean.getMyDynamicData().get(0).getF0001();
//            AppConfig.Id =  bean.getMyDynamicData().get(0).getF0005();
//            view.showToast("登陆成功");
//            view.successLogin();
//        }else {
//            view.showToast("用户名密码错误");
//        }
        view.destoryLoad();
    }

    @Override
    public void fail(String s) {
        view.destoryLoad();
        view.showToast(s);
    }

    @Override
    public void goRequest(String userName, String pws) {
        view.showLoad();
        model.GetDate(userName, pws, this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
