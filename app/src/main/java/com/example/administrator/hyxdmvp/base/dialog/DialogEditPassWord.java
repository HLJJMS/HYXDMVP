package com.example.administrator.hyxdmvp.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.hyxdmvp.R;


public class DialogEditPassWord extends Dialog {
    EditText secret;
    EditText confirmSecret;
    TextView ok;
    TextView center;
    private Context context;
    private DialogClick dialogClick;
    private Animation shake;

    public DialogEditPassWord(Context context, DialogClick dialogClick) {
        super(context);
        this.context = context;
        this.dialogClick = dialogClick;
    }

    public DialogEditPassWord(Context context, int themeResId, DialogClick dialogClick) {
        super(context, themeResId);
        this.context = context;
        this.dialogClick = dialogClick;
    }

    protected DialogEditPassWord(Context context, boolean cancelable, OnCancelListener cancelListener, DialogClick dialogClick) {
        super(context, cancelable, cancelListener);
        this.context = context;
        this.dialogClick = dialogClick;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View layout = LayoutInflater.from(context).inflate(R.layout.dialog_editpassword, null);
        center = (TextView) layout.findViewById(R.id.center);
        secret = (EditText) layout.findViewById(R.id.secret);
        confirmSecret = (EditText) layout.findViewById(R.id.confirmSecret);
        ok = (TextView) layout.findViewById(R.id.ok);
        click();
        setContentView(layout);
    }


    private void click() {
        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClick.closeDialog();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(confirmSecret.getText()) || "".equals(secret.getText())) {
                    dialogClick.isFlase("密码不能为空");
                } else if (confirmSecret.getText() == secret.getText()) {
                    dialogClick.ok(confirmSecret.getText().toString());
                    dialogClick.closeDialog();
                } else {
                    shake = AnimationUtils.loadAnimation(context, R.anim.shake);
                    confirmSecret.startAnimation(shake);
                    dialogClick.isFlase("两次输入不一致");
                }
            }
        });
    }

    public interface DialogClick {
        public void closeDialog();

        public void ok(String pwd);

        public void isFlase(String message);
    }
}
