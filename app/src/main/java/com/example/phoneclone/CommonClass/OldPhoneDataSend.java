package com.example.phoneclone.CommonClass;

import android.view.View;

import com.example.phoneclone.PhoneCloneActivity;

public class OldPhoneDataSend implements View.OnClickListener{
    public final PhoneCloneActivity f0;
    public  OldPhoneDataSend(PhoneCloneActivity phoneCloneActivity) {
        this.f0 = phoneCloneActivity;
    }
    @Override
    public void onClick(View view) {
        PhoneCloneActivity.onOldPhoneSendClick(this.f0, view);
    }
}
