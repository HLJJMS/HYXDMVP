package com.example.administrator.hyxdmvp.ui.view.confirmpassword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.ui.view.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmPassWordActivity extends AppCompatActivity  implements IComfirmPassWordView{


    @BindView(R.id.psw)
    EditText psw;
    @BindView(R.id.pswok)
    EditText pswok;
    @BindView(R.id.ok)
    Button ok;
    private Animation shake;
    private String passWord,passWordConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pass_word);
        ButterKnife.bind(this);
        shake = AnimationUtils.loadAnimation(ConfirmPassWordActivity.this, R.anim.shake);
    }

    @OnClick(R.id.ok)
    public void onViewClicked() {
        passWord = psw.getText().toString();
        passWordConfirm = pswok.getText().toString();
        if ("".equals(passWord)||"".equals(passWordConfirm)) {
            showToast("密码不可以为空");
            psw.startAnimation(shake);
            pswok.startAnimation(shake);

        }else if(passWord.equals(passWordConfirm)){

        }else{
            psw.startAnimation(shake);
            showToast("两次输入密码不一致");
        }
    }

    @Override
    public void showToast( String message) {
        Toast.makeText(this,message ,Toast.LENGTH_LONG).show();
    }
}
