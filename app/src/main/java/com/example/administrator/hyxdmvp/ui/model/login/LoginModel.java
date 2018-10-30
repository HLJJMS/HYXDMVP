package com.example.administrator.hyxdmvp.ui.model.login;

import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.base.BaseOkHttp;
import com.example.administrator.hyxdmvp.bean.LoginBean;
import com.example.administrator.hyxdmvp.ui.presenter.login.ILoginPresenter;

public class LoginModel implements ILoginModel{
    LoginBean loginBean = new LoginBean();
    private  ILoginPresenter presenter;
    @Override
    public void GetDate(String userName, String pws, final ILoginPresenter presenter) {
        BaseOkHttp<LoginBean> okHttp = new BaseOkHttp<LoginBean>(loginBean,LoginBean.class);
        this.presenter = presenter;
        okHttp.getData(AppConfig.Url + AppConfig.General + "a=T50000&b=1|5&d=2:" + userName + "|3:" + pws, new BaseOkHttp.CallBack<LoginBean>() {
            @Override
            public void success(LoginBean bean) {
                presenter.success(bean);
            }

            @Override
            public void fail(String s) {

            }
        });


    }



//    OkHttpClient  client= new OkHttpClient();
//    private String userName,pws;
//    private  ILoginPresenter presenter;
//    @Override
//    public void GetDate(final String userName, final String pws,final ILoginPresenter presenter) {
//       this.userName=userName;
//       this.pws=pws;
//       this.presenter = presenter;
//        Send send = new Send();
//        send.execute();
//    }
//        class Send extends AsyncTask<Void,Void,String>{
//            String result = "";
//            @Override
//            protected String doInBackground(Void... voids) {
//                String url = AppConfig.Url+AppConfig.General+"a=T50000&b=1|5&d=2:"+userName+"|3:"+pws;
//                Log.e("连接",url);
//                Request request= new Request.Builder().url(url).get().build();
//                try {
//                    Response response =  client.newCall(request).execute();
//                    int a = response.code();
//                    result = response.body().string();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return result;
//            }
//            @Override
//            protected void onPostExecute(String s) {
//                super.onPostExecute(s);
//                presenter.callBack(s);
//            }
//        }

}
