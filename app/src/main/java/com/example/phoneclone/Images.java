package com.example.phoneclone;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class Images implements Parcelable {
    public static final Creator<Images> CREATOR = new Creator<Images>() {
        public Images createFromParcel(Parcel parcel) {
            return new Images(parcel);
        }

        public Images[] newArray(int i) {
            return new Images[i];
        }
    };
    private int img;
    private ArrayList<Paths> listofpaths;
    private String name;

    public int describeContents() {
        return 0;
    }

    public Images(String str, ArrayList<Paths> arrayList, int i) {
        this.name = str;
        this.listofpaths = arrayList;
        this.img = i;
    }

    protected Images(Parcel parcel) {
        this.img = parcel.readInt();
        this.name = parcel.readString();
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final ArrayList<Paths> getListofpaths() {
        return this.listofpaths;
    }

    public final void setListofpaths(ArrayList<Paths> arrayList) {
        this.listofpaths = arrayList;
    }

    public final int getImg() {
        return this.img;
    }

    public final void setImg(int i) {
        this.img = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.img);
        parcel.writeString(this.name);
    }
}
