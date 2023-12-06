package com.example.phoneclone.CommonClass;

import android.view.View;

import com.example.phoneclone.PhoneCloneActivity;

public class NewPhoneDataReceive implements View.OnClickListener{
    public final PhoneCloneActivity f0;
    public  NewPhoneDataReceive(PhoneCloneActivity phoneCloneActivity) {
        this.f0 = phoneCloneActivity;
    }
    @Override
    public void onClick(View view) {
        PhoneCloneActivity.onNewPhoneReceiveClick(this.f0, view);
    }
}
