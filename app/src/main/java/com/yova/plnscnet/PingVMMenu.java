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

public class PingVMMenu extends AppCompatActivity {

    private TextView resultText;
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
        setContentView(R.layout.activity_ping_vmmenu);

        LinearLayout back_vm = findViewById(R.id.back_vm);
        LinearLayout VM1Menu = findViewById(R.id.VM1Menu);
        LinearLayout VM2Menu = findViewById(R.id.VM2Menu);
        LinearLayout VM3Menu = findViewById(R.id.VM3Menu);
        LinearLayout VM4Menu = findViewById(R.id.VM4Menu);


        //resultText = findViewById(R.id.pingresult);
        //scrollView = findViewById(R.id.scrollView1);

        back_vm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(PingVMMenu.this, Pingmenu.class));
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        VM1Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PingVMMenu.this, VMSatelite.class));
            }
        });
        VM2Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PingVMMenu.this, VMSatelite.class));
            }
        });
        VM3Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PingVMMenu.this, VMSatelite.class));
            }
        });
        VM4Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PingVMMenu.this, VMSatelite.class));
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