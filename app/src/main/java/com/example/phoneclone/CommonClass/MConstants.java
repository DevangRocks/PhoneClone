package com.example.phoneclone.CommonClass;

import android.net.wifi.WifiManager;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
public final class MConstants {
    public static final MConstants INSTANCE = new MConstants();
    public static final int PERMISSION_REQUEST_CODE = 1122;
    public static final int PORT = 8080;
    private static String[] allPermissionsList = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.ACCESS_FINE_LOCATION", "android.permission.CAMERA"};
    private static String[] allPermissionsList33 = {"android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.ACCESS_FINE_LOCATION", "android.permission.NEARBY_WIFI_DEVICES", "android.permission.CAMERA"};
   // private static ArrayList<DataTransferModel> mListToSend = new ArrayList<>();
    public static final String prefName = "SmartSwitchPref";
    private static WifiManager.LocalOnlyHotspotReservation reservationOfHotspot;

    private MConstants() {
    }

    public final WifiManager.LocalOnlyHotspotReservation getReservationOfHotspot() {
        return reservationOfHotspot;
    }

    public final void setReservationOfHotspot(WifiManager.LocalOnlyHotspotReservation localOnlyHotspotReservation) {
        reservationOfHotspot = localOnlyHotspotReservation;
    }

    public final String[] getAllPermissionsList() {
        return allPermissionsList;
    }

    public final void setAllPermissionsList(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        allPermissionsList = strArr;
    }

    public final String[] getAllPermissionsList33() {
        return allPermissionsList33;
    }

    public final void setAllPermissionsList33(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        allPermissionsList33 = strArr;
    }
}
