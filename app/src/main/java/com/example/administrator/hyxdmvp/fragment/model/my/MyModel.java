package com.example.administrator.hyxdmvp.fragment.model.my;

import android.os.AsyncTask;
import android.util.Log;

import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.fragment.presenter.my.IMyPresenter;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyModel implements IMyModel {
    OkHttpClient client= new OkHttpClient();
    private IMyPresenter myPresenter;
    private String url ;
    @Override
    public void GetUserDate(IMyPresenter myPresenter) {
        this.myPresenter = myPresenter;
        GetUserData getUserDate = new GetUserData();
        getUserDate.execute();
    }
    class GetUserData extends AsyncTask<Void,Void,String>{
        String ok;
        @Override
        protected String doInBackground(Void... voids) {
            url = AppConfig.UrlApp+AppConfig.General + "a="+"tp0000&d=2::" + AppConfig.Id;
            Log.e("连接",url);
            Request request= new Request.Builder().url(url).get().build();
            try {
                Response response =  client.newCall(request).execute();
                ok = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ok;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            myPresenter.callBack(s);
        }
    }

}
