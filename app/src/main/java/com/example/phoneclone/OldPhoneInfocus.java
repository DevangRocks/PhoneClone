package com.example.phoneclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.phoneclone.CommonClass.ControlApkList;
import com.example.phoneclone.CommonClass.ControlAudioList;
import com.example.phoneclone.CommonClass.ControlImageList;
import com.example.phoneclone.CommonClass.ControlVideoList;
import com.example.phoneclone.CommonClass.SelectAllData;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import kotlin.jvm.internal.Intrinsics;

public class OldPhoneInfocus extends AppCompatActivity {
    ImageView back;

    public Map<Integer, View> findViewById = new LinkedHashMap();
    private AlertDialog dialog;
    private ArrayList<Images> imagesList;
    private boolean main_selection_ischeck;
    private int selected;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_phone_infocus);

        this.back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ((CheckBox) findViewById(R.id.selectAllData)).setOnCheckedChangeListener(new SelectAllData(this));
    }

    public static final void onSelectAllCLick(OldPhoneInfocus oldPhoneInfocus, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(oldPhoneInfocus, "this$0");
        if (compoundButton.isPressed()) {
            if (z) {
                ControlApkList.setAllFilesChecked();
                ControlAudioList.setAllFilesChecked();
                ControlImageList.setAllFilesChecked();
                ControlVideoList.setAllFilesChecked();
            } else {
                ControlApkList.setAllFilesUnchecked();
                ControlAudioList.setAllFilesUnchecked();
                ControlImageList.setAllFilesUnchecked();
                ControlVideoList.setAllFilesUnchecked();
            }
            ((MaterialCheckBox) oldPhoneInfocus.findViewById(R.id.checkBox_apps)).setChecked(z);
            ((MaterialCheckBox) oldPhoneInfocus.findViewById(R.id.checkBox_images)).setChecked(z);
            ((MaterialCheckBox) oldPhoneInfocus.findViewById(R.id.checkBox_videos)).setChecked(z);
            ((MaterialCheckBox) oldPhoneInfocus.findViewById(R.id.checkBox_audios)).setChecked(z);
            oldPhoneInfocus.setTotalSelectedFiles();
        }
    }

    public final void setTotalSelectedFiles() {
        int i = ControlImageList.get_total_Images_selected() + ControlVideoList.get_total_videos_selected() + ControlAudioList.get_total_Audios_selected() + ControlApkList.get_total_apks_selected();
        ((AppCompatButton) findViewById(R.id.transfer)).setText("Transfer (" + i + ')');
    }
}