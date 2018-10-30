package com.example.administrator.hyxdmvp.fragment.view.my;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.base.dialog.DialogEditPassWord;
import com.example.administrator.hyxdmvp.base.dialog.Warning;
import com.example.administrator.hyxdmvp.bean.UserDataBean;
import com.example.administrator.hyxdmvp.fragment.presenter.my.MyPresenter;
import com.example.administrator.hyxdmvp.ui.view.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MyFragment extends Fragment implements IMyView {
    @BindView(R.id.userImg)
    ImageView userImg;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.editpassword)
    TextView editpassword;
    @BindView(R.id.version_code)
    TextView versionCode;
    @BindView(R.id.version_ll)
    LinearLayout versionLl;
    @BindView(R.id.exit)
    TextView exit;
    Unbinder unbinder;
    @BindView(R.id.cpName)
    TextView cpName;
    @BindView(R.id.userJob)
    TextView userJob;
    private Warning warning;
    private DialogEditPassWord dialogEditPassWord;
    private Context context;
    private MyPresenter myPresenter;
    private String imgUrl = "http://tst.zhongqizhiyun.com:8020/Uploads/headportrait/";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        myPresenter = new MyPresenter(this);
        myPresenter.getUserDate();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        myPresenter.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.userImg, R.id.editpassword, R.id.version_ll, R.id.exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.userImg:
                break;
            case R.id.editpassword:
                editPwd();
                break;
            case R.id.version_ll:
                break;
            case R.id.exit:
                exit();
                break;
        }
    }

    private void editPwd() {
        dialogEditPassWord = new DialogEditPassWord(getContext(), new DialogEditPassWord.DialogClick() {
            @Override
            public void closeDialog() {
                dialogEditPassWord.cancel();
            }

            @Override
            public void ok(String pwd) {

            }

            @Override
            public void isFlase(String message) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });

        dialogEditPassWord.show();

    }

    private void exit() {
        warning = new Warning(getContext(), new Warning.DialogClick() {

            @Override
            public void closeDialog() {
                warning.cancel();
            }

            @Override
            public void ok() {
//                清空缓存密码
                SharedPreferences preferences = context.getSharedPreferences("ZQZY", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
//                跳转activity后清空所有actity
                Intent intent = new Intent(context, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        warning.show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void getUserDataCallBack(UserDataBean bean) {
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(this).load(imgUrl+bean.getMyDynamicData().get(0).getF0047()).apply(requestOptions).into(userImg);
        userName.setText(bean.getMyDynamicData().get(0).getF0003());
        userJob.setText(bean.getMyDynamicData().get(0).getF0026());
        cpName.setText(bean.getMyDynamicData().get(0).getF0021());
    }
}
