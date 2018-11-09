package com.example.administrator.hyxdmvp.ui.view.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.base.DropDownView;
import com.example.administrator.hyxdmvp.bean.DropDownItem;

import java.util.LinkedList;

public class Main2Activity extends AppCompatActivity {
    private DropDownView downView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    private void init() {
        downView = (DropDownView) findViewById(R.id.drop_down_view);
        LinkedList<DropDownItem> data = new LinkedList<DropDownItem>();
        data.add(new DropDownItem("xd001", "第一项"));
        data.add(new DropDownItem("xd002", "第二项"));
        data.add(new DropDownItem("xd003", "第三项"));
        data.add(new DropDownItem("xd004", "第四项"));
        downView.setmData(data);
        downView.addTextChangedListener(new TextChange());
    }

    private class TextChange implements TextWatcher {
        @Override
        public void afterTextChanged(Editable arg0) {
            Toast.makeText(Main2Activity.this,
                    "code : " + downView.getCode() + "\nvalue: " + downView.getValue(),
                    Toast.LENGTH_LONG).show();
        }
        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
        }

    }


}
