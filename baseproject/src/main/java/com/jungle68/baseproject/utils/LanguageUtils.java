package com.jungle68.baseproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2017/6/3
 * @Contact master.jungle68@gmail.com
 */

public class LanguageUtils {
    public static final String LANGUAGE = "Language";
    public static final String COUNTRY = "country";

    public static void changeAppLanguage(Context context, Locale locale) {
        changeAppLanguage(context, locale, true);
    }

    /**
     * 更改应用语言
     *
     * @param context application context
     * @param locale  language locale
     * @param isSave  is need save
     */
    public static void changeAppLanguage(Context context, Locale locale, boolean isSave) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        resources.updateConfiguration(configuration, metrics);
        if (isSave) {
            saveLanguageSetting(context, locale);
        }
    }


    public static Locale getAppLocale(Context context) {
        return new Locale(getAppLanguage(context), getAppCountry(context));
    }

    public static String getAppLanguage(Context context) {
        String name = context.getPackageName() + "_" + LANGUAGE;
        SharedPreferences preferences =
                context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getString(LANGUAGE,
                Locale.getDefault().getLanguage());
    }

    public static String getAppCountry(Context context) {
        String name = context.getPackageName() + "_" + LANGUAGE;
        SharedPreferences preferences =
                context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getString(COUNTRY,
                Locale.getDefault().getCountry());
    }

    /**
     * @param context
     * @param locale
     */
    private static void saveLanguageSetting(Context context, Locale locale) {
        String name = context.getPackageName() + "_" + LANGUAGE;
        SharedPreferences preferences =
                context.getSharedPreferences(name, Context.MODE_PRIVATE);
        preferences.edit().putString(LANGUAGE, locale.getLanguage()).apply();
        preferences.edit().putString(COUNTRY, locale.getCountry()).apply();
    }
}
