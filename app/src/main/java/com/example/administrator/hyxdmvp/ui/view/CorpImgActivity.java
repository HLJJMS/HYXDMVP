package com.example.administrator.hyxdmvp.ui.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.diyView.imageCrop.CropImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CorpImgActivity extends AppCompatActivity {


    @BindView(R.id.cropOk)
    Button cropOk;
    @BindView(R.id.cropDel)
    Button cropDel;
    Uri uri;
    @BindView(R.id.cropImageView)
    CropImageView cropImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corp_img);
        ButterKnife.bind(this);
        getData();
        setUri();
    }


    private void getData() {
        Intent intent = getIntent();
         uri = Uri.parse(intent.getStringExtra("image_uri"));
    }

    private void setUri() {
        cropImageView.setImageURI(uri);

    }

    @OnClick({R.id.cropOk, R.id.cropDel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cropOk:
                Bitmap cropBitMap = cropImageView.getCroppedImage();
                break;
            case R.id.cropDel:
                finish();
                break;
        }
    }
}
