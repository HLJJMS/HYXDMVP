package com.example.administrator.hyxdmvp.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.base.BaseOkHttp;
import com.example.administrator.hyxdmvp.bean.UserAllBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity {
    @BindView(R.id.et_3)
    EditText et3;
    @BindView(R.id.et_32)
    EditText et32;
    @BindView(R.id.et_4)
    EditText et4;
    @BindView(R.id.et_6)
    EditText et6;
    @BindView(R.id.et_7)
    EditText et7;
    @BindView(R.id.et_14)
    EditText et14;
    @BindView(R.id.et_15)
    EditText et15;
    @BindView(R.id.et_16)
    EditText et16;
    @BindView(R.id.et_20)
    TextView et20;
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);
        data();
        sendGetDetail();
    }

    private void data() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        title.setText("详情信息");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });
    }


    private void sendGetDetail() {
        UserAllBean bean = new UserAllBean();
        BaseOkHttp<UserAllBean> baseOkHttp;
        baseOkHttp = new BaseOkHttp<UserAllBean>(bean, UserAllBean.class);
        baseOkHttp.getData(new StringBuffer(AppConfig.UrlApp()).append(AppConfig.General).append("a=TP0000&d=2::").append(id).toString(), new BaseOkHttp.CallBack<UserAllBean>() {
            @Override
            public void success(UserAllBean bean) {
                if (bean.getCode().equals("0") && bean.getMyDynamicData().size() > 0) {
                    UserAllBean.MyDynamicDataBean item = bean.getMyDynamicData().get(0);
                    et3.setText(item.getF0003());
                    et4.setText(item.getF0004());
                    et6.setText(item.getF0006());
                    et7.setText(item.getF0007());
                    et14.setText(item.getF0014());
                    et15.setText(item.getF0015());
                    et32.setText(item.getF0032());
                    et16.setText(item.getF0016());
                    et20.setText(item.getF0020().substring(0, 10));
                }
            }

            @Override
            public void fail(String s) {
                showToast(s);
            }
        });
    }

    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
