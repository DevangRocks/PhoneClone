package com.example.phoneclone;

import java.io.Serializable;

public class SenderInfocusModel implements Serializable {
    String name;
    String path;
    int progress1;
    long size;
    int thumbnail;
    String type;

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public int getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(int i) {
        this.thumbnail = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getProgress1() {
        return this.progress1;
    }

    public void setProgress1(int i) {
        this.progress1 = i;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
