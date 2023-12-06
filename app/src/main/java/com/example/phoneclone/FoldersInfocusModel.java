package com.example.phoneclone;

import kotlin.jvm.internal.Intrinsics;
public final class FoldersInfocusModel {
    private final String assertFileStringUri;
    private String name;
    private int size;

    public static /* synthetic */ FoldersInfocusModel copy$default(FoldersInfocusModel foldersInfocusModel, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = foldersInfocusModel.name;
        }
        if ((i2 & 2) != 0) {
            i = foldersInfocusModel.size;
        }
        if ((i2 & 4) != 0) {
            str2 = foldersInfocusModel.assertFileStringUri;
        }
        return foldersInfocusModel.copy(str, i, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.size;
    }

    public final String component3() {
        return this.assertFileStringUri;
    }

    public final FoldersInfocusModel copy(String str, int i, String str2) {
       // Intrinsics.checkNotNullParameter(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkNotNullParameter(str2, "assertFileStringUri");
        return new FoldersInfocusModel(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FoldersInfocusModel)) {
            return false;
        }
        FoldersInfocusModel foldersInfocusModel = (FoldersInfocusModel) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) foldersInfocusModel.name) && this.size == foldersInfocusModel.size && Intrinsics.areEqual((Object) this.assertFileStringUri, (Object) foldersInfocusModel.assertFileStringUri);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.size) * 31) + this.assertFileStringUri.hashCode();
    }

    public String toString() {
        return "FoldersInfocusModel(name=" + this.name + ", size=" + this.size + ", assertFileStringUri=" + this.assertFileStringUri + ')';
    }

    public FoldersInfocusModel(String str, int i, String str2) {
       // Intrinsics.checkNotNullParameter(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkNotNullParameter(str2, "assertFileStringUri");
        this.name = str;
        this.size = i;
        this.assertFileStringUri = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final String getAssertFileStringUri() {
        return this.assertFileStringUri;
    }
}
