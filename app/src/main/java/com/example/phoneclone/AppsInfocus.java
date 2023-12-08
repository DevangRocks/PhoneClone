package com.example.phoneclone;

import kotlin.jvm.internal.Intrinsics;

public final class AppsInfocus {
    private long apkSize;
    private String appPath;
    private boolean isSelectedFile;
    private final String lastModified;
    private String name;
    private String packageName;

    public static /* synthetic */ AppsInfocus copy$default(AppsInfocus appsInfocus, String str, String str2, long j, String str3, boolean z, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appsInfocus.name;
        }
        if ((i & 2) != 0) {
            str2 = appsInfocus.packageName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            j = appsInfocus.apkSize;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str3 = appsInfocus.appPath;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            z = appsInfocus.isSelectedFile;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str4 = appsInfocus.lastModified;
        }
        return appsInfocus.copy(str, str5, j2, str6, z2, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.packageName;
    }

    public final long component3() {
        return this.apkSize;
    }

    public final String component4() {
        return this.appPath;
    }

    public final boolean component5() {
        return this.isSelectedFile;
    }

    public final String component6() {
        return this.lastModified;
    }

    public final AppsInfocus copy(String str, String str2, long j, String str3, boolean z, String str4) {
        Intrinsics.checkNotNullParameter(str2, "packageName");
        Intrinsics.checkNotNullParameter(str3, "appPath");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "lastModified");
        return new AppsInfocus(str, str2, j, str3, z, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppsInfocus)) {
            return false;
        }
        AppsInfocus appsInfocus = (AppsInfocus) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) appsInfocus.name) && Intrinsics.areEqual((Object) this.packageName, (Object) appsInfocus.packageName) && this.apkSize == appsInfocus.apkSize && Intrinsics.areEqual((Object) this.appPath, (Object) appsInfocus.appPath) && this.isSelectedFile == appsInfocus.isSelectedFile && Intrinsics.areEqual((Object) this.lastModified, (Object) appsInfocus.lastModified);
    }

    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.packageName.hashCode()) * 31) ) * 31) + this.appPath.hashCode()) * 31;
        boolean z = this.isSelectedFile;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.lastModified.hashCode();
    }

    public String toString() {
        return "AppsInfocus(name=" + this.name + ", packageName=" + this.packageName + ", apkSize=" + this.apkSize + ", appPath=" + this.appPath + ", isSelectedFile=" + this.isSelectedFile + ", lastModified=" + this.lastModified + ')';
    }

    public AppsInfocus(String str, String str2, long j, String str3, boolean z, String str4) {
        Intrinsics.checkNotNullParameter(str2, "packageName");
        Intrinsics.checkNotNullParameter(str3, "appPath");
        Intrinsics.checkNotNullParameter(str4, "lastModified");
        this.name = str;
        this.packageName = str2;
        this.apkSize = j;
        this.appPath = str3;
        this.isSelectedFile = z;
        this.lastModified = str4;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final long getApkSize() {
        return this.apkSize;
    }

    public final void setApkSize(long j) {
        this.apkSize = j;
    }

    public final String getAppPath() {
        return this.appPath;
    }

    public final void setAppPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appPath = str;
    }

    public final boolean isSelectedFile() {
        return this.isSelectedFile;
    }

    public final void setSelectedFile(boolean z) {
        this.isSelectedFile = z;
    }

    public final String getLastModified() {
        return this.lastModified;
    }
}
