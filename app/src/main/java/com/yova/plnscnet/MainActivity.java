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

public class MainActivity extends AppCompatActivity {


    private TextView nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        nameUser = findViewById(R.id.textView2);

        // Make a username set to someone login with - Yv

        String username=getIntent().getStringExtra("email");
        if(!TextUtils.isEmpty(username)){
            nameUser.setText(""+username);
        }

        LinearLayout button1 = findViewById(R.id.cert);
        LinearLayout button2 = findViewById(R.id.course);
        LinearLayout button3 = findViewById(R.id.skills);
        LinearLayout button4 = findViewById(R.id.wol);
        LinearLayout button5 = findViewById(R.id.FlashlightMenu);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Flashlight.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WoL.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Route.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PortScanning.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pingnet.class));
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