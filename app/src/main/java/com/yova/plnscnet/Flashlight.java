package com.yova.plnscnet;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Flashlight extends AppCompatActivity {

    boolean isTorchOn = false;

    private Button FlashlightButton;
    private Button FlashlightOff;

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
        setContentView(R.layout.content_flashlight);

        LinearLayout buttonOn = findViewById(R.id.FlashlightButton);
        LinearLayout buttonOff = findViewById(R.id.FlashlightOff);

        buttonOn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                torchToggle("on");
            }
        });

        buttonOff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                torchToggle("off");
            }
        });
    }

    private void torchToggle(String command) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            String cameraId = null; // Usually back camera is at 0 position.
            try {
                if (camManager != null) {
                    cameraId = camManager.getCameraIdList()[0];
                }
                if (camManager != null) {
                    if (command.equals("on")) {
                        camManager.setTorchMode(cameraId, true);   // Turn ON
                        isTorchOn = true;
                    } else {
                        camManager.setTorchMode(cameraId, false);  // Turn OFF
                        isTorchOn = false;
                    }
                }
            } catch (CameraAccessException e) {
                e.getMessage();
            }
        }
    }
}