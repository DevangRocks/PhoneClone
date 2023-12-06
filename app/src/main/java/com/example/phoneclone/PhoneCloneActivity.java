package com.example.phoneclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.phoneclone.CommonClass.NewPhoneDataReceive;
import com.example.phoneclone.CommonClass.OldPhoneDataSend;
import com.google.android.material.button.MaterialButton;

import kotlin.jvm.internal.Intrinsics;

public class PhoneCloneActivity extends AppCompatActivity {
    ImageView back;
    private static final int SHARE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_clone);

        this.back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ((MaterialButton) findViewById(R.id.newPhone)).setOnClickListener(new NewPhoneDataReceive(this));
        ((MaterialButton) findViewById(R.id.oldPhone)).setOnClickListener(new OldPhoneDataSend(this));
    }

    public static final void onNewPhoneReceiveClick(PhoneCloneActivity phoneCloneActivity, View view) {
        Intent shareIntent = new Intent(phoneCloneActivity, ReceiveDataInfocusActivity.class);
        shareIntent.setAction("android.intent.action.SEND_MULTIPLE");
        //shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
        phoneCloneActivity.startActivityForResult(shareIntent, SHARE_REQUEST);
    }

    public static final void onOldPhoneSendClick(PhoneCloneActivity phoneCloneActivity, View view) {
        Intent i = new Intent(phoneCloneActivity, OldPhoneInfocus.class);
        phoneCloneActivity.startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SHARE_REQUEST) {
            if (resultCode == RESULT_OK) {
                finish();
            }
        }
    }
}