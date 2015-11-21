package com.example.android.secure_me;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer mp;
    int TAKE_PHOTO_CODE = 0;
    public static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        newdir.mkdirs();
        mp = MediaPlayer.create(this, R.raw.alarm);
        Button alert=(Button)findViewById(R.id.ALERT);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.reset();
                    mp.release();
                } else
                    mp.start();
            }
        });
        Button came=(Button)findViewById(R.id.CAMERA);
        came.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                String file = dir + count + ".jpg";
                File newfile = new File(file);
                try {
                    newfile.createNewFile();
                } catch (IOException e) {
                }
                Uri outputFileUri = Uri.fromFile(newfile);
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });
        Button defence= (Button)findViewById(R.id.DEFENCE);
        defence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Defense.class));
                finish();
            }
        });

    }
    long last_click = 0;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_POWER) {
            // Check if power button was pressed twice in last second
            if ((System.currentTimeMillis() - last_click) <= 1000) {
                call();
                return true;
            }
            last_click = System.currentTimeMillis();
        }
        return super.dispatchKeyEvent(event);
    }

    public void call() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "7835941084"));
        startActivity(intent);
        }
    @Override
    public void onClick(View v) {
    }
}
