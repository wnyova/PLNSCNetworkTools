package com.yova.plnscnet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.yova.plnscnet.ping.PingResult;
import com.yova.plnscnet.ping.PingStats;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Pingserver extends AppCompatActivity {

    private TextView resultText;
    private EditText editIpAddress;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_pingserver);

        LinearLayout back_server = findViewById(R.id.back_server);
        LinearLayout ServerMenu1 = findViewById(R.id.ServerMenu1);
        LinearLayout ServerMenu2 = findViewById(R.id.ServerMenu2);
        LinearLayout ServerMenu3 = findViewById(R.id.ServerMenu3);
        LinearLayout ServerMenu4 = findViewById(R.id.ServerMenu4);


        //resultText = findViewById(R.id.pingresult);
        //scrollView = findViewById(R.id.scrollView1);

        back_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pingserver.this, Pingmenu.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        ServerMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pingserver.this, PingDNS.class));

               /* AlertDialog.Builder builder = new AlertDialog.Builder(Pingserver.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.customview, viewGroup, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            doPing();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();*/

            }
        });
    }




    /*private void appendResultsText(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultText.append(text + "\n");
                /*scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });*/


}