package com.yova.plnscnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.yova.plnscnet.SubnetDevices;
import com.yova.plnscnet.subnet.Device;

import java.net.InetAddress;
import java.util.ArrayList;

public class Route extends AppCompatActivity {

    private TextView resultText;
    // private EditText editIpAddress;
    private ScrollView scrollView;
    private Button subnetDevicesButton;




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
        setContentView(R.layout.activity_route);

        resultText = findViewById(R.id.resultText);
       // editIpAddress = findViewById(R.id.editIpAddress);
        scrollView = findViewById(R.id.scrollView1);

        LinearLayout subnetDevicesButton = findViewById(R.id.subnetDevicesButton);
        LinearLayout resetbutton = findViewById(R.id.resetall);


        resetbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

    /*    InetAddress ipAddress = IPTools.getLocalIPv4Address();
        if (ipAddress != null){
            editIpAddress.setText(ipAddress.getHostAddress());
        } */

        subnetDevicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            findSubnetDevices();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
    private void appendResultsText(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultText.append(text + "\n");
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }

    private void setEnabled(final View view, final boolean enabled) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (view != null) {
                    view.setEnabled(enabled);
                }
            }
        });
    }

    private void findSubnetDevices() {

        setEnabled(subnetDevicesButton, false);

        final long startTimeMillis = System.currentTimeMillis();

        SubnetDevices subnetDevices = SubnetDevices.fromLocalAddress().findDevices(new SubnetDevices.OnSubnetDeviceFound() {
            @Override
            public void onDeviceFound(Device device) {
                appendResultsText("Device: " + device.ip+" "+ device.hostname);
            }

            @Override
            public void onFinished(ArrayList<Device> devicesFound) {
                float timeTaken =  (System.currentTimeMillis() - startTimeMillis)/1000.0f;
                appendResultsText("Devices Found: " + devicesFound.size());
                appendResultsText("Finished "+timeTaken+" s");
                setEnabled(subnetDevicesButton, true);
            }

        });

    }

}