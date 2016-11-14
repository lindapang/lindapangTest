package com.project.lindapang.toastlibrary.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.project.lindapang.toastlibrary.R;

/**
 * 全屏显示的对话框
 * Created by linyonghui on 2016/11/13.
 */

public class MyDialog extends Dialog {

    private Context mContext;
    private LayoutInflater mInflater;                            //获取布局信息
    private TextView mTextViewCountDown;                        //倒计时文本框
    private LinearLayout mLinearLayoutCountDown;               //点击关闭


    /**
     * 构造方法
     * @param context
     */
    public MyDialog(Context context) {
        super(context, R.style.dialog_fullscreen);
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = mInflater.inflate(R.layout.dialog_fullscreen,null);
        mTextViewCountDown = (TextView) contentView.findViewById(R.id.textview_count_down);
        mLinearLayoutCountDown = (LinearLayout) contentView.findViewById(R.id.linearlayout_count_down);
        setContentView(contentView);
        mLinearLayoutCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


    @Override
    public void show() {
        super.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 3; i >= 0 ; i--){
                    if(isShowing()){
                        ((Activity)mContext).runOnUiThread(new MyRunnable(i));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 更新倒计时文本
     */
    private class MyRunnable implements Runnable {
        private int mCountTime;             //倒计时时间
        public MyRunnable(int countTime){
            this.mCountTime = countTime;
        }
        @Override
        public void run() {
            if(mCountTime == 0){
                dismiss();
            }
            mTextViewCountDown.setText(String.valueOf(mCountTime));
        }
    }
}
