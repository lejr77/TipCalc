package com.android.amagi.tipcalc.fragments;

import com.android.amagi.tipcalc.models.TipRecord;

/**
 * Created by ljaimes on 18/07/2016.
 */
public interface TipHistoryListFragmentListerner {
    void addToList(TipRecord record);
    void clearList();
}
