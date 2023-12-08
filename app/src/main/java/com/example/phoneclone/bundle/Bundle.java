package com.example.phoneclone.bundle;

import java.io.IOException;
import java.util.ArrayList;

public class Bundle extends ArrayList<Item> {

    private long mTotalSize = 0;

    public void addItem(Item item) throws IOException {
        add(item);
        mTotalSize += item.getLongProperty(Item.SIZE, true);
    }
    public long getTotalSize() {
        return mTotalSize;
    }
}
