package com.example.mybooklist;

public class Objects {
    private String mauthorName;
    private String mBookName;

    public String getMauthorName() {
        return mauthorName;
    }

    public String getmBookName() {
        return mBookName;
    }

    public Objects(String mauthorName, String mBookName) {
        this.mauthorName = mauthorName;
        this.mBookName = mBookName;
    }
}
