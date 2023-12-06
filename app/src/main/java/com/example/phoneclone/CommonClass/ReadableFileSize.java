package com.example.phoneclone.CommonClass;

import java.text.DecimalFormat;

public class ReadableFileSize {
    public static String readableFileSize(long j) {
        if (j <= 1) {
            return j + " byte";
        }
        double d = (double) j;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.##").format(d / Math.pow(1024.0d, (double) log10)) + " " + new String[]{"bytes", "KB", "MB", "GB", "TB", "PB", "EB"}[log10];
    }
}
