package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Web_view extends AppCompatActivity {

    private Button mBtn;
    private AlertDialog.Builder builder;
    private ProgressDialog dialog;
    private WebView mWbview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

//        mBtn=findViewById(R.id.btn);
//
//        dialog=new ProgressDialog(this);
//        dialog.setTitle("Dialog Title");
//        dialog.setMessage("Message");
//
//        mBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                builder=new AlertDialog.Builder(Web_view.this);
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        finish();
//                    }
//                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialog.show();
//
//                    }
//                }).setTitle("Title").setMessage("Message").create();
//                builder.show();
//            }
//        });

        mWbview =findViewById(R.id.webview);
        mWbview.setWebViewClient(new WebViewClient());
        mWbview.getSettings().setJavaScriptEnabled(true);
        mWbview.loadUrl("https://www.silicon.ac.in");
    }
}
