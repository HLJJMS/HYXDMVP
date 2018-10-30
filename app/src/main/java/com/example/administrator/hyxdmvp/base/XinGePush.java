package com.example.administrator.hyxdmvp.base;

import android.app.Activity;
import android.util.Log;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;

public class XinGePush {
    public void resigter(Activity activity ,String id) {
        XGPushManager.registerPush(activity,id,
                new XGIOperateCallback() {
                    @Override
                    public void onSuccess(Object data, int flag) {
                        Log.e("结果   ", "+++ register push sucess. token:" + data + "flag" + flag);
                    }
                    @Override
                    public void onFail(Object data, int errCode, String msg) {
                        Log.e("结果   ",
                                "+++ register push fail. token:" + data
                                        + ", errCode:" + errCode + ",msg:"
                                        + msg);
                    }
                });
    }
}
