package com.example.phoneclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.example.phoneclone.transfer.TransferService;
import com.example.phoneclone.util.Permissions;
import com.example.phoneclone.util.Settings;

public class TransferActivity extends AppCompatActivity {
    private static final String TAG = "TransferActivity";
    private static final int INTRO_REQUEST = 1;

    private Settings mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = new Settings(this);
        setContentView(R.layout.activity_transfer);

        boolean introShown = mSettings.getBoolean(Settings.Key.INTRO_SHOWN);
        Log.i(TAG, introShown ? "intro has been shown" : "intro has not been shown");

        if (!introShown) {
            Log.i(TAG, "launching intro activity");

        } else if (!Permissions.haveStoragePermission(this)) {
            Permissions.requestStoragePermission(this);
        } else {
            finishInit();
        }
    }

    private void finishInit() {
        Log.i(TAG, "finishing initialization of activity");

        // Setup the action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String deviceName = mSettings.getString(Settings.Key.DEVICE_NAME);

        TransferService.startStopService(this, mSettings.getBoolean(Settings.Key.BEHAVIOR_RECEIVE));

        // Add the transfer fragment
        TransferFragment mainFragment = new TransferFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list_container, mainFragment)
                .commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INTRO_REQUEST) {
            if (resultCode == RESULT_OK) {
                Log.i(TAG, "intro finished");
                mSettings.putBoolean(Settings.Key.INTRO_SHOWN, true);
                finishInit();
            } else {
                finish();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (Permissions.obtainedStoragePermission(requestCode, grantResults)) {
            finishInit();
        } else {
            finish();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}