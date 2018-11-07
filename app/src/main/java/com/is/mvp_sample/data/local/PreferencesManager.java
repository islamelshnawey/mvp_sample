package com.is.mvp_sample.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 *
 * @author Islam
 * @date 10/11/2018
 */

public class PreferencesManager {

    SharedPreferences mSharedPreferences;

    private static final String MY_PREFS = "PREF";

    private static final String LANGUAGE = "lang";

    public PreferencesManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }

    private static SharedPreferences getPref(Context context) {
        return context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
    }

    public void clear(Context context) {
        getPref(context).edit().clear().apply();
    }

    /**
     * set app language
     * @param lang
     */
    public void setLanguage(String lang) {
        mSharedPreferences.edit().putString(LANGUAGE, lang).apply();
    }

    /**
     * get app language
     * @return
     */
    public String getLanguage() {
        return mSharedPreferences.getString(LANGUAGE, "ar");
    }

}
