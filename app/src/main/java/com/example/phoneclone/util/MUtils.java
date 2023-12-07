package com.example.phoneclone.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.phoneclone.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

public final class MUtils {
    public static final MUtils INSTANCE = new MUtils();

    private MUtils() {
    }

    public final void presentToast(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "text");
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

    public final File appFile(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appPackageName");
        try {
            return new File(context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public final String size(long j) {
        long j2 = j;
        double d = (double) (j2 / ((long) 1024));
        double d2 = (double) 1024;
        double d3 = d / d2;
        double d4 = d3 / d2;
        double d5 = d4 / d2;
        int i = (j2 > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID ? 1 : (j2 == PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID ? 0 : -1));
        if (i < 0) {
            return j2 + " Bytes";
        } else if (i >= 0 && j2 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            StringBuilder sb = new StringBuilder();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb.append(format);
            sb.append(" KB");
            return sb.toString();
        } else if (j2 >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED && j2 < 1073741824) {
            StringBuilder sb2 = new StringBuilder();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            sb2.append(format2);
            sb2.append(" MB");
            return sb2.toString();
        } else if (j2 >= 1073741824 && j2 < 1099511627776L) {
            StringBuilder sb3 = new StringBuilder();
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d4)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            sb3.append(format3);
            sb3.append(" GB");
            return sb3.toString();
        } else if (j2 < 1099511627776L) {
            return "";
        } else {
            StringBuilder sb4 = new StringBuilder();
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format4 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d5)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
            sb4.append(format4);
            sb4.append(" TB");
            return sb4.toString();
        }
    }

    public final boolean isNetworkEnabled(LocationManager locationManager) {
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        try {
            return locationManager.isProviderEnabled("network");
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isGPSEnabled(LocationManager locationManager) {
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        try {
            return locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean verifyAppInstallation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List arrayList = new ArrayList(CollectionsKt.listOf("com.android.vending", "com.google.android.feedback"));
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null && arrayList.contains(installerPackageName);
    }

//    public static /* synthetic */ String formatDateForGroup$default(MUtils mUtils, long j, Context context, boolean z, int i, Object obj) {
//        if ((i & 2) != 0) {
//            z = false;
//        }
//        return mUtils.formatDateForGroup(j, context, z);
//    }

//    public final String formatDateForGroup(long j, Context context, boolean z) {
//        Intrinsics.checkNotNullParameter(context, "context");
//        Calendar instance = Calendar.getInstance();
//        instance.setTimeInMillis(j);
//        if (DateUtils.isToday(j)) {
//            String string = context.getString(R.string.today);
//            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.today)");
//            return string;
//        } else if (DateUtils.isToday(86400000 + j)) {
//            String string2 = context.getString(R.string.yesterday);
//            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.yesterday)");
//            return string2;
//        } else {
//            String str = "dd/MM/yyyy";
//            if (!z && isThisYear(j)) {
//               // str = StringsKt.trim(StringsKt.trim(StringsKt.trim(StringsKt.trim((CharSequence) StringsKt.replace$default(str, "y", "", false, 4, (Object) null)).toString(), '-'), '.'), '/');
//            }
//            return DateFormat.format(str, instance).toString();
//        }
//    }

    public final boolean isThisYear(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        time.set(System.currentTimeMillis());
        return i == time.year;
    }
    public static final void showPermissionDialog$lambda$0(Dialog dialog, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$permissionDialog");
        Intrinsics.checkNotNullParameter(function1, "$callback");
        dialog.dismiss();
        function1.invoke(true);
    }

    /* access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$1(Function1 function1, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(function1, "$callback");
        Intrinsics.checkNotNullParameter(dialog, "$permissionDialog");
        function1.invoke(false);
        dialog.dismiss();
    }
}
