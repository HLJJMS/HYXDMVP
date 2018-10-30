package com.example.administrator.hyxdmvp.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.hyxdmvp.R;

public class Warning extends Dialog {
    private Context context;
    private TextView ok,center;
    private DialogClick dialogClick;
    public Warning(Context context, DialogClick dialogClick) {
        super(context);
        this.context = context;
        this.dialogClick = dialogClick;
    }

    public Warning(Context context, int themeResId,DialogClick dialogClick) {
        super(context, themeResId);
        this.context = context;
        this.dialogClick = dialogClick;
    }

    protected Warning(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener,DialogClick dialogClick) {
        super(context, cancelable, cancelListener);
        this.context = context;
        this.dialogClick = dialogClick;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View layout = LayoutInflater.from(context).inflate(R.layout.dialog_exit, null);
        center = (TextView) layout.findViewById(R.id.center);
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
                dialogClick.ok();
            }
        });

    }
    public interface DialogClick {
        public void closeDialog();
        public void ok();
    }
}
