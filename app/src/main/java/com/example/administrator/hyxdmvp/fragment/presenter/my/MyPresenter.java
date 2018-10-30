package com.example.administrator.hyxdmvp.fragment.presenter.my;

import com.alibaba.fastjson.JSONObject;
import com.example.administrator.hyxdmvp.bean.UserDataBean;
import com.example.administrator.hyxdmvp.fragment.model.my.MyModel;
import com.example.administrator.hyxdmvp.fragment.view.my.IMyView;
import com.example.administrator.hyxdmvp.fragment.view.my.MyFragment;
import com.google.gson.Gson;

public class MyPresenter implements IMyPresenter {
    private IMyView view;
    private MyModel myModel = new MyModel();
    public MyPresenter(MyFragment view) {
        this.view = view;
    }
    @Override
    public void callBack(String result) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        String code = jsonObject.getString("code");
        if(code.equals("0")){
            Gson gson = new Gson();
            UserDataBean bean = gson.fromJson(jsonObject.toJSONString(),UserDataBean.class);
            view.getUserDataCallBack(bean);
        }else{
            view.showToast("网络异常");
        }
    }

    @Override
    public void getUserDate() {
        myModel.GetUserDate(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
