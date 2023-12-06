package com.example.phoneclone.model;

import android.app.LauncherActivity;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.phoneclone.ListItem;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
public final class ContactModel implements Parcelable, ListItem {
    public static final Parcelable.Creator<ContactModel> CREATOR = new Creator();
    private final String absolutePath;
    private final String contactName;
    private final String contactNumber;
    private boolean isSelected;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FileModel.kt */
    public static final class Creator implements Parcelable.Creator<ContactModel> {
        public final ContactModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContactModel(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final ContactModel[] newArray(int i) {
            return new ContactModel[i];
        }
    }

    public static /* synthetic */ ContactModel copy$default(ContactModel contactModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactModel.contactName;
        }
        if ((i & 2) != 0) {
            str2 = contactModel.contactNumber;
        }
        if ((i & 4) != 0) {
            str3 = contactModel.absolutePath;
        }
        return contactModel.copy(str, str2, str3);
    }

    public static /* synthetic */ void isSelected$annotations() {
    }

    public final String component1() {
        return this.contactName;
    }

    public final String component2() {
        return this.contactNumber;
    }

    public final String component3() {
        return this.absolutePath;
    }

    public final ContactModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "contactName");
        Intrinsics.checkNotNullParameter(str2, "contactNumber");
        Intrinsics.checkNotNullParameter(str3, "absolutePath");
        return new ContactModel(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactModel)) {
            return false;
        }
        ContactModel contactModel = (ContactModel) obj;
        return Intrinsics.areEqual((Object) this.contactName, (Object) contactModel.contactName) && Intrinsics.areEqual((Object) this.contactNumber, (Object) contactModel.contactNumber) && Intrinsics.areEqual((Object) this.absolutePath, (Object) contactModel.absolutePath);
    }

    public int hashCode() {
        return (((this.contactName.hashCode() * 31) + this.contactNumber.hashCode()) * 31) + this.absolutePath.hashCode();
    }

    public String toString() {
        return "ContactModel(contactName=" + this.contactName + ", contactNumber=" + this.contactNumber + ", absolutePath=" + this.absolutePath + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.contactName);
        parcel.writeString(this.contactNumber);
        parcel.writeString(this.absolutePath);
    }

    public ContactModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "contactName");
        Intrinsics.checkNotNullParameter(str2, "contactNumber");
        Intrinsics.checkNotNullParameter(str3, "absolutePath");
        this.contactName = str;
        this.contactNumber = str2;
        this.absolutePath = str3;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getContactNumber() {
        return this.contactNumber;
    }

    public final String getAbsolutePath() {
        return this.absolutePath;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public long getListId() {
        return ((long) this.contactNumber.hashCode()) + ((long) getClass().hashCode());
    }
}
