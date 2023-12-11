package com.example.phoneclone.model;

import android.content.pm.ApplicationInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
public final class FileModel {
    private final ApplicationInfo appInfo;
    private boolean isSelected;
    private final String name;
    private final String path;
    private final String type;

    public static  FileModel copy$default(FileModel fileModel, String str, String str2, String str3, ApplicationInfo applicationInfo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileModel.name;
        }
        if ((i & 2) != 0) {
            str2 = fileModel.path;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = fileModel.type;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            applicationInfo = fileModel.appInfo;
        }
        ApplicationInfo applicationInfo2 = applicationInfo;
        if ((i & 16) != 0) {
            z = fileModel.isSelected;
        }
        return fileModel.copy(str, str4, str5, applicationInfo2, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.type;
    }

    public final ApplicationInfo component4() {
        return this.appInfo;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    public final FileModel copy(String str, String str2, String str3, ApplicationInfo applicationInfo, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "type");
        return new FileModel(str, str2, str3, applicationInfo, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileModel)) {
            return false;
        }
        FileModel fileModel = (FileModel) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) fileModel.name) && Intrinsics.areEqual((Object) this.path, (Object) fileModel.path) && Intrinsics.areEqual((Object) this.type, (Object) fileModel.type) && Intrinsics.areEqual((Object) this.appInfo, (Object) fileModel.appInfo) && this.isSelected == fileModel.isSelected;
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.path.hashCode()) * 31) + this.type.hashCode()) * 31;
        ApplicationInfo applicationInfo = this.appInfo;
        int hashCode2 = (hashCode + (applicationInfo == null ? 0 : applicationInfo.hashCode())) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
    }

    public String toString() {
        return "FileModel(name=" + this.name + ", path=" + this.path + ", type=" + this.type + ", appInfo=" + this.appInfo + ", isSelected=" + this.isSelected + ')';
    }

    public FileModel(String str, String str2, String str3, ApplicationInfo applicationInfo, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "type");
        this.name = str;
        this.path = str2;
        this.type = str3;
        this.appInfo = applicationInfo;
        this.isSelected = z;
    }

    public  FileModel(String str, String str2, String str3, ApplicationInfo applicationInfo, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : applicationInfo, (i & 16) != 0 ? false : z);
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getType() {
        return this.type;
    }

    public final ApplicationInfo getAppInfo() {
        return this.appInfo;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
