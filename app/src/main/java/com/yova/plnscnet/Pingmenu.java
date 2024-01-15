package com.yova.plnscnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Pingmenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingmenu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        // Make a username set to someone login with - Yv


        LinearLayout button1 = findViewById(R.id.server);
        LinearLayout button2 = findViewById(R.id.aps);
        LinearLayout button3 = findViewById(R.id.vm);
        LinearLayout button4 = findViewById(R.id.internet);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pingmenu.this, Pingserver.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pingmenu.this, Pingaps.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pingmenu.this, PingVMMenu.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pingmenu.this, Pingnet.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

/*        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homepage.class));
            }
        });*/
    }
}