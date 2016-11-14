package com.project.lindapang.mytoastresource;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.lindapang.mytoastresource.view.MyFullDialog;
import com.project.lindapang.toastlibrary.view.MyDialog;

/**
 * 全屏dialog测试类
 */
public class MainActivity extends AppCompatActivity {
    private Button btnDialog1;
    private Button btnDialog2;
    private Button btnDialog3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialog1 = (Button) findViewById(R.id.btn_show_dialog1);
        btnDialog2 = (Button) findViewById(R.id.btn_show_dialog2);
        btnDialog3 = (Button) findViewById(R.id.btn_show_dialog3);
        intDialog1();
        intDialog2();
        intDialog3();

    }

    private void intDialog3() {
        final MyFullDialog myFullDialog = new MyFullDialog(MainActivity.this);
        btnDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDialog myDialog = new MyDialog(MainActivity.this);
                myDialog.show();
            }
        });


    }

    private void intDialog2() {
//           TextView box;
//           final Dialog      info    = new Dialog(MainActivity.this,R.style.FullScreenToast);
//           ScrollView scroll;
//
//        info.setContentView(R.layout.dialog_fullscreen);
//        info.setTitle("Info");
//        info.setCancelable(true);
//        info.setCanceledOnTouchOutside(true);
//        info.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        info.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        scroll = ((ScrollView) info.findViewById(R.id.scrollviewinfo));
//        scroll.setPersistentDrawingCache(ScrollView.PERSISTENT_NO_CACHE);
//        scroll.setScrollbarFadingEnabled(false);
//        box = (TextView) info.findViewById(R.id.infotext);
//        box.setText(text);
//        btnDialog2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                info.show();
//            }
//        });

    }

    private void intDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.FullScreenToast);
        builder.setMessage("测试数据");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"确定按钮",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final Dialog dialog = builder.create();
        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }
}
