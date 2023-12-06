package com.example.phoneclone;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
public final class FileModelInfocus {
    private boolean isSelectedFile;
    private final String lastModified;
    private final String name;
    private final String path;
    private final long size;
    private final int thumbnail;
    private final String type;

    public static /* synthetic */ FileModelInfocus copy$default(FileModelInfocus fileModelInfocus, String str, String str2, long j, String str3, int i, String str4, boolean z, int i2, Object obj) {
        FileModelInfocus fileModelInfocus2 = fileModelInfocus;
        return fileModelInfocus.copy((i2 & 1) != 0 ? fileModelInfocus2.name : str, (i2 & 2) != 0 ? fileModelInfocus2.path : str2, (i2 & 4) != 0 ? fileModelInfocus2.size : j, (i2 & 8) != 0 ? fileModelInfocus2.type : str3, (i2 & 16) != 0 ? fileModelInfocus2.thumbnail : i, (i2 & 32) != 0 ? fileModelInfocus2.lastModified : str4, (i2 & 64) != 0 ? fileModelInfocus2.isSelectedFile : z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.path;
    }

    public final long component3() {
        return this.size;
    }

    public final String component4() {
        return this.type;
    }

    public final int component5() {
        return this.thumbnail;
    }

    public final String component6() {
        return this.lastModified;
    }

    public final boolean component7() {
        return this.isSelectedFile;
    }

    public final FileModelInfocus copy(String str, String str2, long j, String str3, int i, String str4, boolean z) {
       // Intrinsics.checkNotNullParameter(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "type");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "lastModified");
        return new FileModelInfocus(str, str2, j, str3, i, str5, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileModelInfocus)) {
            return false;
        }
        FileModelInfocus fileModelInfocus = (FileModelInfocus) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) fileModelInfocus.name) && Intrinsics.areEqual((Object) this.path, (Object) fileModelInfocus.path) && this.size == fileModelInfocus.size && Intrinsics.areEqual((Object) this.type, (Object) fileModelInfocus.type) && this.thumbnail == fileModelInfocus.thumbnail && Intrinsics.areEqual((Object) this.lastModified, (Object) fileModelInfocus.lastModified) && this.isSelectedFile == fileModelInfocus.isSelectedFile;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.name.hashCode() * 31) + this.path.hashCode()) * 31)) * 31) + this.type.hashCode()) * 31) + this.thumbnail) * 31) + this.lastModified.hashCode()) * 31;
        boolean z = this.isSelectedFile;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "FileModelInfocus(name=" + this.name + ", path=" + this.path + ", size=" + this.size + ", type=" + this.type + ", thumbnail=" + this.thumbnail + ", lastModified=" + this.lastModified + ", isSelectedFile=" + this.isSelectedFile + ')';
    }

    public FileModelInfocus(String str, String str2, long j, String str3, int i, String str4, boolean z) {
        //Intrinsics.checkNotNullParameter(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "lastModified");
        this.name = str;
        this.path = str2;
        this.size = j;
        this.type = str3;
        this.thumbnail = i;
        this.lastModified = str4;
        this.isSelectedFile = z;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getType() {
        return this.type;
    }

    public final String getLastModified() {
        return this.lastModified;
    }

    public final int getThumbnail() {
        return this.thumbnail;
    }

    public final boolean isSelectedFile() {
        return this.isSelectedFile;
    }

    public final void setSelectedFile(boolean z) {
        this.isSelectedFile = z;
    }
}
