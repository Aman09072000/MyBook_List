package com.example.mybooklist;

public class Objects {
    private String mauthorName;
    private String mBookName;
  private String mImage;

    public Objects(String mauthorName, String mBookName) {
        this.mauthorName = mauthorName;
        this.mBookName = mBookName;
//        this.mImage = mImage;
    }

    public String getMauthorName() {
        return mauthorName;
    }

    public String getmBookName() {
        return mBookName;
    }

//    public String getmImage() {
//        return mImage;
//    }
}
