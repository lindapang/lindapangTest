package com.project.lindapang.mytoastresource.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.project.lindapang.mytoastresource.R;


/**
 * 全屏Dialog
 * Created by linyonghui on 2016/11/13.
 */

public class MyFullDialog extends Dialog {

    public MyFullDialog(Context context) {
        super(context,R.style.FullScreenToast);
//        setOwnerActivity((Activity) context);
    }

    public MyFullDialog(Context context, int themeResId) {
        super(context,themeResId);
    }

    protected MyFullDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

}
