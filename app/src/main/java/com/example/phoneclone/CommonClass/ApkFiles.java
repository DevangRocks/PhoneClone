package com.example.phoneclone.CommonClass;

import android.graphics.drawable.Drawable;
import java.io.File;

public class ApkFiles {
    String apkPath;
    Drawable apkdrawable;
    String apkname;
    File file;
    boolean ischecked;

    public ApkFiles(String str, String str2, Drawable drawable, boolean z) {
        this.apkPath = str;
        this.apkdrawable = drawable;
        this.apkname = str2;
        this.ischecked = z;
        this.file = new File(str);
    }

    public String getApkname() {
        return this.apkname;
    }

    public void setApkname(String str) {
        this.apkname = str;
    }

    public Drawable getApkdrawable() {
        return this.apkdrawable;
    }

    public void setApkdrawable(Drawable drawable) {
        this.apkdrawable = drawable;
    }

    public void setApkPath(String str) {
        this.apkPath = str;
    }

    public String getApkPath() {
        return this.apkPath;
    }

    public boolean isIschecked() {
        return this.ischecked;
    }

    public void setIschecked(boolean z) {
        this.ischecked = z;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public String getSizeOfEachFolder() {
        return ReadableFileSize.readableFileSize(this.file.length());
    }

    public long getfileinbytes() {
        return this.file.length();
    }
}
