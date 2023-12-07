package com.example.phoneclone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.phoneclone.databinding.ActivityChooseConnectionBinding;
import com.example.phoneclone.util.MUtils;

import kotlin.jvm.internal.Intrinsics;

public class ChooseConnectionActivity extends AppCompatActivity {
    private ActivityChooseConnectionBinding binding;
    private LocationManager locationManager;
    private String user;
    private WifiManager wifiManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChooseConnectionBinding inflate = ActivityChooseConnectionBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        ActivityChooseConnectionBinding activityChooseConnectionBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        Object systemService = getSystemService(LOCATION_SERVICE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
        @SuppressLint("WrongConstant") Object systemService2 = getApplicationContext().getSystemService("wifi");

        this.wifiManager = (WifiManager) systemService2;
        this.user = String.valueOf(getIntent().getStringExtra("user"));
        ActivityChooseConnectionBinding activityChooseConnectionBinding2 = this.binding;
        if (activityChooseConnectionBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChooseConnectionBinding2 = null;
        }
        activityChooseConnectionBinding2.layoutWifi.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChooseConnectionActivity.onCreate$lambda$1(ChooseConnectionActivity.this, view);
            }
        });
    }

    public static final void onCreate$lambda$1(ChooseConnectionActivity activityChooseConnection, View view) {
        Intrinsics.checkNotNullParameter(activityChooseConnection, "this$0");
        WifiManager wifiManager2 = activityChooseConnection.wifiManager;
        LocationManager locationManager2 = null;
        if (wifiManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wifiManager");
            wifiManager2 = null;
        }
        if (!wifiManager2.isWifiEnabled()) {
            Toast.makeText(activityChooseConnection, "Please Turn On WIFI", Toast.LENGTH_SHORT).show();
            activityChooseConnection.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            return;
        }
        MUtils mUtils = MUtils.INSTANCE;
        LocationManager locationManager3 = activityChooseConnection.locationManager;
        if (locationManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
            locationManager3 = null;
        }
        if (!mUtils.isNetworkEnabled(locationManager3)) {
            MUtils mUtils2 = MUtils.INSTANCE;
            LocationManager locationManager4 = activityChooseConnection.locationManager;
            if (locationManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationManager");
            } else {
                locationManager2 = locationManager4;
            }
            if (!mUtils2.isGPSEnabled(locationManager2)) {
                MUtils.INSTANCE.presentToast(activityChooseConnection, "Please turn on location");
                activityChooseConnection.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                return;
            }
        }
                activityChooseConnection.onCreate$lambda$1$lambda$0(activityChooseConnection);

    }

    public static final void onCreate$lambda$1$lambda$0(ChooseConnectionActivity activityChooseConnection) {
        Intrinsics.checkNotNullParameter(activityChooseConnection, "this$0");
       // Intent intent = new Intent(activityChooseConnection, ActivityExploreNearByDevices.class);
        String str = activityChooseConnection.user;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            str = null;
        }
      //  activityChooseConnection.startActivity(intent.putExtra("user", str));
    }
}