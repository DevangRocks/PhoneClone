package com.example.phoneclone.CommonClass;

import com.example.phoneclone.Paths;

import java.util.ArrayList;
import java.util.List;

public class ImageFiles {
    String audio_file_name;
    boolean check_value;
    int count = 0;
    ArrayList<Paths> listofpaths;

    public ImageFiles(String str, ArrayList<Paths> arrayList) {
        this.audio_file_name = str;
        this.listofpaths = arrayList;
    }

    public String getImage_file_name() {
        return this.audio_file_name;
    }

    public List<Paths> getListofpaths() {
        return this.listofpaths;
    }

    public void increament_Count() {
        this.count++;
    }

    public void decrement_Count() {
        int i = this.count;
        if (i != 0) {
            this.count = i - 1;
        }
    }

    public int get_total_count() {
        return this.count;
    }

    public boolean isCheck_value() {
        return this.check_value;
    }

    public void setCheck_value(boolean z) {
        this.check_value = z;
    }

    public void setcheckedAll() {
        for (int i = 0; i < this.listofpaths.size(); i++) {
            this.listofpaths.get(i).setCheck_value(true);
        }
        this.count = this.listofpaths.size();
    }

    public void setuncheckedall() {
        for (int i = 0; i < this.listofpaths.size(); i++) {
            this.listofpaths.get(i).setCheck_value(false);
        }
        this.count = 0;
    }
}
