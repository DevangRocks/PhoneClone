package com.example.phoneclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.util.Log;
import android.view.View;

import com.example.phoneclone.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        ActivityMainBinding activityMainBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());

        binding.layoutOldPhone.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MainActivity.OldPhoneData(MainActivity.this, view);
            }
        });

        getStorage();
    }

    private void getStorage() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        long blockSize2 = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        String str10 = "B";
        String[] strArr = {str10, "KB", "MB", "GB", "TB"};
        double d = (double) blockSize;
        long j2 = blockSize - blockSize2;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        if (blockSize > 0) {
            StringBuilder sb = new StringBuilder();
            j = blockSize2;
            str = "#,##0.#";
            sb.append(new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, (double) log10)));
            sb.append(10);
            sb.append(strArr[log10]);
            str2 = sb.toString();
            str10 = str10;
        } else {
            j = blockSize2;
            str = "#,##0.#";
            str2 = "";
        }
        String[] strArr2 = {str10, "KB", "MB", "GB", "TB"};
        long j3 = j;
        double d2 = (double) j3;
        int log102 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        String str11 = "";
        if (j3 > 0) {
            str3 = str2;
            StringBuilder sb2 = new StringBuilder();
            i = log10;
            sb2.append(new DecimalFormat(str).format(d2 / Math.pow(1024.0d, (double) log102)));
            str3 = str2;
            sb2.append(' ');
            sb2.append(strArr2[log102]);
            str8 = sb2.toString();
            Log.d("abc", "Storage: " + (j3 / ((long) 1073741824)));
            str4 = "KB";
            str5 = "MB";
            str6 = "GB";
            str7 = "TB";
        } else {
            str3 = str2;
            i = log10;
            str4 = "KB";
            str5 = "MB";
            str6 = "GB";
            str7 = "TB";
            str8 = str11;
        }
        String[] strArr3 = {str10, str4, str5, str6, str7};
        long j4 = j2;
        double d3 = (double) j4;
        int log103 = (int) (Math.log10(d3) / Math.log10(1024.0d));
        if (j4 > 0) {
            StringBuilder sb3 = new StringBuilder();
            long j5 = j4;
            sb3.append(new DecimalFormat(str).format(d3 / Math.pow(1024.0d, (double) log103)));
            sb3.append(' ');
            sb3.append(strArr3[log103]);
            str9 = sb3.toString();
            Log.d("abc", "Storage: " + (j5 / ((long) 1073741824)));
        } else {
            str9 = str11;
        }
        Math.pow(1024.0d, (double) log102);
        Math.pow(1024.0d, (double) i);
        replace(str3, " ", "", false, 4, (Object) null);
        replace(str9, " ", "", false, 4, (Object) null);
        replace(str8, " ", "", false, 4, (Object) null);
        ActivityMainBinding activityMainBinding = this.binding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        activityMainBinding.tvUsedSpace.setText(str9);
        ActivityMainBinding activityMainBinding3 = this.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding3 = null;
        }
        activityMainBinding3.tvTotalStorage.setText(str3);
        ActivityMainBinding activityMainBinding4 = this.binding;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding4;
        }
        activityMainBinding2.tvAvailableSpace.setText(str8);
        Log.e("abc", "Available : " + str8 + "..." + str3 + "..... " + str9);
    }

    public static  String replace(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(str, str2, str3, z);
    }

    public static final void OldPhoneData(MainActivity mainActivity, View view) {
        MainActivity.OnOldPhoneDataClcik(mainActivity);
    }

    public static final void OnOldPhoneDataClcik(MainActivity mainActivity) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        Intent intent = new Intent(mainActivity, PhoneCloneDataActivity.class);
        ActivityMainBinding activityMainBinding = mainActivity.binding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        intent.putExtra("used", activityMainBinding.tvUsedSpace.getText().toString());
        ActivityMainBinding activityMainBinding3 = mainActivity.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding3 = null;
        }
        intent.putExtra("available", activityMainBinding3.tvAvailableSpace.getText().toString());
        ActivityMainBinding activityMainBinding4 = mainActivity.binding;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding4;
        }
        intent.putExtra("total", activityMainBinding2.tvTotalStorage.getText().toString());
        mainActivity.startActivity(intent);
    }
}