package com.android.amagi.tipcalc;

import android.app.Application;

/**
 * Created by ljaimes on 15/07/2016.
 */
public class TipCalcApp extends Application {
    private final static String ABOUT_URL ="https://about.me/luisjaimes1";

    public  String getAboutUrl() {
        return ABOUT_URL;
    }
}
