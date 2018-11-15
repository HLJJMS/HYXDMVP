package com.example.administrator.hyxdmvp.ui.view.login;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.base.Quit;
import com.example.administrator.hyxdmvp.base.dialog.Loading;
import com.example.administrator.hyxdmvp.ui.presenter.login.LoginPresenter;
import com.example.administrator.hyxdmvp.ui.view.forgetpassword.ForGetPassWordActivity;
import com.example.administrator.hyxdmvp.ui.view.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    @BindView(R.id.editpsw)
    TextView editpsw;
    @BindView(R.id.service)
    EditText service;
    private LoginPresenter presenter;
    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.ok)
    Button ok;
    private Context context;
    private Quit quit = new Quit();
    private Dialog dialog;
    private SharedPreferences sp;
    private String userId, psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
        context = this;
        sp = getSharedPreferences("ZQZY", Context.MODE_PRIVATE);
        service.setText(AppConfig.Url);
        getData();
    }

    //查找SharedPreferences里的数据
    private void getData() {
        userId = sp.getString(AppConfig.UserIdSharedPreferences, "");
        psw = sp.getString(AppConfig.PassWordSharedPreferences, "");
        if (!"".equals(userId) && !"".equals(psw)) {
            number.setText(userId);
            password.setText(psw);
            presenter.goRequest(userId, psw);
        }
    }

    @Override
    public void showLoad() {
        dialog = Loading.createLoadingDialog(context, "加载中...");
    }

    @Override
    public void destoryLoad() {
        Loading.closeDialog(dialog);
        dialog = null;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    //    登陆成功
    @Override
    public void successLogin() {
        //获取到edit对象
        SharedPreferences.Editor edit = sp.edit();
        //通过editor对象写入数据
        edit.putString(AppConfig.UserIdSharedPreferences, number.getText().toString());
        edit.putString(AppConfig.PassWordSharedPreferences, password.getText().toString());
        //提交数据存入到xml文件中
        edit.commit();
        AppConfig.UserId = number.getText().toString();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            quit.ClickTwiceQuit(context);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.ok, R.id.editpsw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ok:
                AppConfig.Url = service.getText().toString();
                if (!"".equals(number.getText().toString()) && !"".equals(password.getText().toString())) {
                    presenter.goRequest(number.getText().toString(), password.getText().toString());
                } else {
                    Toast.makeText(this, "用户名密码不可为空", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.editpsw:
                Intent intent = new Intent(LoginActivity.this, ForGetPassWordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
