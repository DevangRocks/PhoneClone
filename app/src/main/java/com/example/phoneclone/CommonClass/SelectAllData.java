package com.example.phoneclone.CommonClass;

import android.widget.CompoundButton;

import com.example.phoneclone.OldPhoneInfocus;

public class SelectAllData implements CompoundButton.OnCheckedChangeListener{
    public final OldPhoneInfocus f$0;

    public SelectAllData(OldPhoneInfocus oldPhoneInfocus) {
        this.f$0 = oldPhoneInfocus;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        OldPhoneInfocus.onSelectAllCLick(this.f$0, compoundButton, z);
    }
}
