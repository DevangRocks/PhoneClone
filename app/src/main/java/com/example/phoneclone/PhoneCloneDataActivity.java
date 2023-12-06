package com.example.phoneclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.example.phoneclone.CommonClass.MConstants;
import com.example.phoneclone.databinding.ActivityPhoneCloneDataBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

public class PhoneCloneDataActivity extends AppCompatActivity {
    ActivityPhoneCloneDataBinding binding;
    public static final int SHARE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhoneCloneDataBinding inflate = ActivityPhoneCloneDataBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        ActivityPhoneCloneDataBinding activityMainBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        binding.tvUsedSpace.setText(getIntent().getStringExtra("used"));
        binding.tvTotalStorage.setText(getIntent().getStringExtra("total"));
        binding.tvAvailableSpace.setText(getIntent().getStringExtra("available"));
        binding.layoutOldPhone.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PhoneCloneDataActivity.OldPhoneDataClick(PhoneCloneDataActivity.this, view);
            }
        });
        binding.layoutNewPhone.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PhoneCloneDataActivity.NewPhoneDataClick(PhoneCloneDataActivity.this, view);
            }
        });
    }

    public static void NewPhoneDataClick(PhoneCloneDataActivity phoneCloneDataActivity, View view) {
        Intrinsics.checkNotNullParameter(phoneCloneDataActivity, "this$0");
        if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.addCategory("android.intent.category.DEFAULT");
                String format = String.format("package:%s", Arrays.copyOf(new Object[]{phoneCloneDataActivity.getPackageName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                intent.setData(Uri.parse(format));
                phoneCloneDataActivity.startActivityForResult(intent, 2000);
                return;
            } catch (Exception unused) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                phoneCloneDataActivity.startActivityForResult(intent2, 2000);
            }
        }
        if (phoneCloneDataActivity.checkIfPermissionsGranted()) {
//            phoneCloneDataActivity.startActivity(new Intent(phoneCloneDataActivity, ReceiveDataInfocusActivity.class).putExtra("user", "receiver"));

            Intent shareIntent = new Intent(phoneCloneDataActivity, ReceiveDataInfocusActivity.class);
            shareIntent.setAction("android.intent.action.SEND_MULTIPLE");
            //shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
            phoneCloneDataActivity.startActivityForResult(shareIntent, SHARE_REQUEST);
        }
    }

    public static void OldPhoneDataClick(PhoneCloneDataActivity phoneCloneDataActivity, View view) {
        Intrinsics.checkNotNullParameter(phoneCloneDataActivity, "this$0");
        if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.addCategory("android.intent.category.DEFAULT");
                //StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("package:%s", Arrays.copyOf(new Object[]{phoneCloneDataActivity.getPackageName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                intent.setData(Uri.parse(format));
                phoneCloneDataActivity.startActivityForResult(intent, 2000);
                return;
            } catch (Exception unused) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                phoneCloneDataActivity.startActivityForResult(intent2, 2000);
            }
        }
        if (phoneCloneDataActivity.checkIfPermissionsGranted()) {
            Intent i = new Intent(phoneCloneDataActivity, LoadAllDataActivity.class);
            i.putExtra("total", phoneCloneDataActivity.binding.tvTotalStorage.getText().toString());
            phoneCloneDataActivity.startActivity(i);
        }
    }

    private final boolean checkIfPermissionsGranted() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 33) {
            for (String str : MConstants.INSTANCE.getAllPermissionsList33()) {
                if (ContextCompat.checkSelfPermission(this, str) != 0) {
                    arrayList.add(str);
                }
            }
        } else {
            for (String str2 : MConstants.INSTANCE.getAllPermissionsList()) {
                if (ContextCompat.checkSelfPermission(this, str2) != 0) {
                    arrayList.add(str2);
                }
            }
        }
        Collection collection = arrayList;
        if (!(!collection.isEmpty())) {
            return true;
        }
        ActivityCompat.requestPermissions(this, (String[]) collection.toArray(new String[0]), MConstants.PERMISSION_REQUEST_CODE);
        return false;
    }
}