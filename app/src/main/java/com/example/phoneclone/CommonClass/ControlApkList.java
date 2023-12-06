package com.example.phoneclone.CommonClass;

import java.util.ArrayList;
import java.util.List;

public class ControlApkList {
    static List<ApkFiles> all_apksArrayList = new ArrayList();

    public static void addApkObject(ApkFiles apkFiles) {
        all_apksArrayList.add(apkFiles);
    }

    public static List<ApkFiles> getAllapklist() {
        return all_apksArrayList;
    }

    public static void setAllFilesChecked() {
        for (ApkFiles ischecked : all_apksArrayList) {
            ischecked.setIschecked(true);
        }
    }

    public static void setAllFilesUnchecked() {
        for (ApkFiles ischecked : all_apksArrayList) {
            ischecked.setIschecked(false);
        }
    }

    public static int get_total_apks() {
        return all_apksArrayList.size();
    }

    public static int get_total_apks_selected() {
        int i = 0;
        for (ApkFiles isIschecked : all_apksArrayList) {
            if (isIschecked.isIschecked()) {
                i++;
            }
        }
        return i;
    }

    public static String Total_file_size() {
        long j = 0;
        for (ApkFiles apkFiles : all_apksArrayList) {
            j += apkFiles.getfileinbytes();
        }
        return ReadableFileSize.readableFileSize(j);
    }

    public static List<ApkFiles> get_apk_data() {
        ArrayList arrayList = new ArrayList();
        for (ApkFiles next : all_apksArrayList) {
            if (next.isIschecked()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
