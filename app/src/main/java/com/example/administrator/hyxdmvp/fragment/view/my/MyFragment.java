package com.example.administrator.hyxdmvp.fragment.view.my;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.base.PermissionDynamic;
import com.example.administrator.hyxdmvp.base.dialog.DialogEditPassWord;
import com.example.administrator.hyxdmvp.base.dialog.Warning;
import com.example.administrator.hyxdmvp.bean.UserDataBean;
import com.example.administrator.hyxdmvp.fragment.presenter.my.MyPresenter;
import com.example.administrator.hyxdmvp.ui.view.CorpImgActivity;
import com.example.administrator.hyxdmvp.ui.view.UserDetailActivity;
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
    @BindView(R.id.userJob)
    TextView userJob;
    @BindView(R.id.userid)
    TextView userid;
    @BindView(R.id.cpno)
    TextView cpno;
    @BindView(R.id.cpname)
    TextView cpname;
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
                ReadAndWrite(this);
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (null != data) {
                Uri uri = data.getData();
                Intent intent = new Intent();
                intent.putExtra("image_uri", uri.toString());
                intent.setClass(getActivity(), CorpImgActivity.class);
                startActivity(intent);
            }

        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void getUserDataCallBack(UserDataBean bean) {
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(this).load(imgUrl + bean.getMyDynamicData().get(0).getF0047()).apply(requestOptions).into(userImg);
        userName.setText(bean.getMyDynamicData().get(0).getF0003());
        userJob.setText(bean.getMyDynamicData().get(0).getF0026());
        cpname.setText(bean.getMyDynamicData().get(0).getF0021());
        cpno.setText(bean.getMyDynamicData().get(0).getF0001());
        userid.setText(AppConfig.UserId);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            int one = grantResults[0];
            int two = grantResults[1];
            Log.e("星", "星");
            if (one == PackageManager.PERMISSION_GRANTED && two == PackageManager.PERMISSION_GRANTED) {
                Log.e("星是", "星是");
                selectPhoto();
            } else {
                boolean isWrite = ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permissions[0]);
                boolean isRead = ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permissions[1]);
                if (!isWrite || !isRead) {
                    Toast.makeText(getContext(), "您以禁止读写权限", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void selectPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        // 调用剪切功能
        MyFragment.this.startActivityForResult(intent, 0);
    }

    public void ReadAndWrite(Fragment fragment) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int white = ContextCompat.checkSelfPermission(fragment.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int read = ContextCompat.checkSelfPermission(fragment.getContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
            if (white == PackageManager.PERMISSION_GRANTED && PackageManager.PERMISSION_GRANTED == read) {
                Log.e("可以", "可以");
                MyFragment.this.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            } else {
                Log.e("禁止", "禁止");
                MyFragment.this.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        } else {
            Log.e("地下", "M以下");

        }
    }
}
