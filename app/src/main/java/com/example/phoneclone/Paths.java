package com.example.phoneclone;

public class Paths {
    private int img;
    private boolean isSelected;
    private String path;

    public Paths(String str, boolean z, int i) {
        this.path = str;
        this.isSelected = z;
        this.img = i;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final int getImg() {
        return this.img;
    }

    public final void setImg(int i) {
        this.img = i;
    }

    public void setCheck_value(boolean z) {
        this.isSelected = z;
    }

    public boolean isCheck_value() {
        return this.isSelected;
    }
}
