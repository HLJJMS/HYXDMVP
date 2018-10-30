package com.example.administrator.hyxdmvp.ui.view.forgetpassword;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.hyxdmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForGetPassWordActivity extends AppCompatActivity implements IForGetPassWordView {

    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.get_verification_code)
    Button getVerificationCode;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.verification_code)
    EditText verificationCode;
    private Context context;
    //线程控制信号
    private boolean isThread=true;
    Handler handler = new time();
    //倒计时时间
    private int countDown=60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_get_pass_word);
        ButterKnife.bind(this);
        context = this;
    }

    @OnClick({R.id.get_verification_code, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get_verification_code:
                if (!"".equals(number.getText().toString()) && !"".equals(phone.getText().toString())) {
                    showToast("OK");
                    sendVerificationCodeIng();
                } else {
                    showToast("账号手机号不能为空");
                }
                break;
            case R.id.ok:
                break;
        }
    }
    //现实Toast
    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
//    点击发送验证码后按钮禁用变色开启线程
    private void sendVerificationCodeIng(){
        isThread = true;
        getVerificationCode.setClickable(false);
        getVerificationCode.setBackground(getResources().getDrawable(R.drawable.white_button_flase));
        getVerificationCode.setTextColor(Color.parseColor("#e6e6e6"));
        Thread task = new Thread( new Sendding());
        task.start();
    }
//    时间到后恢复按钮，计时器，线程标志
    private void sendVerificationCodeEnd(){
        countDown = 60;
        isThread = false;
        getVerificationCode.setClickable(true);
        getVerificationCode.setBackground(getResources().getDrawable(R.drawable.white_button));
        getVerificationCode.setTextColor(Color.parseColor("#66b2ff"));
        getVerificationCode.setText("重新发送");
    }
    //发送验证码时倒计时线程
    class Sendding implements Runnable{
        @Override
        public void run() {
            while (isThread){
                Message msg = new Message();
                msg.arg1 = countDown-1;
                countDown = countDown-1;
                handler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//    倒计时读秒线程穿时间给主线程
    class time extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            getVerificationCode.setText("("+String.valueOf(msg.arg1)+"s)"+"后重新发送");
            if(String.valueOf(msg.arg1).equals("0")){
                sendVerificationCodeEnd();
            }
        }
    }

}
