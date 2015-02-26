package com.geoquiz.praveen.geoquiz;

/**
 * Created by Praveen on 1/8/2015.
 */
public class TestData {
    private int mquestion;
    private boolean mboolean;

    TestData(int mq, boolean mb){
        mquestion = mq;
        mboolean = mb;
    }

    public int getMquestion(){
        return mquestion;
    }

    public boolean getmBoolean(){
        return mboolean;
    }
};
