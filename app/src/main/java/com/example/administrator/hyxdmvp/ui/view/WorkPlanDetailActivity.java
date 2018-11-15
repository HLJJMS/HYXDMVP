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
import com.example.administrator.hyxdmvp.bean.WorkPlanDetailBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WorkPlanDetailActivity extends AppCompatActivity {

    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.et_3)
    EditText et3;
    @BindView(R.id.et_4)
    EditText et4;
    @BindView(R.id.et_9)
    EditText et9;
    @BindView(R.id.et_10)
    EditText et10;
    @BindView(R.id.time_start)
    TextView timeStart;
    @BindView(R.id.time_end)
    TextView timeEnd;
    @BindView(R.id.et_5)
    EditText et5;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_contract)
    TextView tvContract;
    @BindView(R.id.tv_9)
    TextView tv9;
    @BindView(R.id.tv_6)
    TextView tv6;
    @BindView(R.id.tv_7)
    TextView tv7;
    @BindView(R.id.updata)
    TextView updata;
    @BindView(R.id.look)
    TextView look;
    @BindView(R.id.download)
    TextView download;
    private  String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_plan_detail);
        ButterKnife.bind(this);
        intentDate();
        getData();
    }

    private void getData() {
        WorkPlanDetailBean bean = new WorkPlanDetailBean();
        BaseOkHttp<WorkPlanDetailBean> baseOkHttp = new BaseOkHttp<>(bean,WorkPlanDetailBean.class);
        baseOkHttp.getData(new StringBuffer().append(AppConfig.UrlApp()).append(AppConfig.General).append("a=TR0003&d=0::").append(id).toString(), new BaseOkHttp.CallBack<WorkPlanDetailBean>() {
            @Override
            public void success(WorkPlanDetailBean bean) {
                if (bean.getCode().equals("0") && bean.getMyDynamicData().size() > 0) {
                    et3.setText(bean.getMyDynamicData().get(0).getF0003());
                    et4.setText(bean.getMyDynamicData().get(0).getF0004());
                    et9.setText(bean.getMyDynamicData().get(0).getF0009());
                    et10.setText(bean.getMyDynamicData().get(0).getF0010());
                    timeStart.setText(bean.getMyDynamicData().get(0).getF0013().substring(0, 10));
                    timeEnd.setText(bean.getMyDynamicData().get(0).getF0015().substring(0, 10));
                }
            }

            @Override
            public void fail(String s) {
                showToast(s);
            }
        });
    }

    private void intentDate() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        title.setText("详情信息");
    }

    @OnClick({R.id.time_start, R.id.time_end, R.id.updata, R.id.look, R.id.download,R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.time_start:
                break;
            case R.id.time_end:
                break;
            case R.id.updata:
                break;
            case R.id.look:
                break;
            case R.id.download:
                break;
            case R.id.back:
                finish();
                break;
        }
    }
    public void showToast(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
