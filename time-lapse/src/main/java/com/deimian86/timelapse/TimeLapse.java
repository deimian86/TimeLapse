package com.deimian86.timelapse;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Main class of this library
 * Created by deimian86 on 19/07/2017.
 */
public class TimeLapse {

    private static volatile TimeLapse singleton = null;

    private final Context context; // Required
    private Date startDate;
    private Locale locale;

    private TimeLapse(TimeLapse.Builder builder) {
        this.context = builder.context;
    }

    public static TimeLapse with(Context mContext) {
        if (singleton == null) {
            synchronized (TimeLapse.class) {
                if (singleton == null) {
                    if (mContext == null) {
                        throw new IllegalStateException("context == null");
                    }
                    singleton = new Builder(mContext).build();
                }
            }
        }
        return singleton;
    }

    private static class Builder {

        private final Context context;

        private Builder(@NonNull Context context) {
            this.context = context.getApplicationContext();
        }

        private TimeLapse build() {
            return new TimeLapse(this);
        }

    }

    public TimeLapse date(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public TimeLapse locale(Locale locale) {
        this.locale = locale;
        return this;
    }

    public String getLapse() {
        String mString = "";
        SimpleDateFormat txtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date actualDate = new Date();
        txtFormat.format(actualDate);
        // Tenemos la fecha inicial y la actual ahora operamos con ellas
        long diff = actualDate.getTime() - startDate.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        // Formateamos la cadena
        if (diffDays == 0) {
            if (diffHours == 0) {
                if (diffMinutes < 10) {
                    mString = getLocaleStringResource(context, locale, R.string.lapse_moments_ago, diffMinutes);
                } else {
                    mString = getLocaleStringResource(context, locale, R.string.lapse_minutes_ago, diffMinutes);
                }
            } else if (diffHours == 1) {
                mString = getLocaleStringResource(context, locale, R.string.lapse_hour_ago, diffHours);
            } else if (diffHours > 1) {
                mString = getLocaleStringResource(context, locale, R.string.lapse_hours_ago, diffHours);
            }
        } else if (diffDays == 1) {
            mString = getLocaleStringResource(context, locale, R.string.lapse_day_ago, diffDays);
        } else if (diffDays > 1 && diffDays < 7) {
            mString = getLocaleStringResource(context, locale, R.string.lapse_days_ago, diffDays);
        } else if (diffDays == 7) {
            mString = getLocaleStringResource(context, locale, R.string.lapse_week_ago, diffDays);
        } else if (diffDays > 7 && diffDays < 14) {
            mString = getLocaleStringResource(context, locale, R.string.lapse_days_ago, diffDays);
        } else if (diffDays == 14) {
            mString = getLocaleStringResource(context, locale, R.string.lapse_weeks_ago, 2);
        } else if (diffDays > 14) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            mString = formato.format(startDate);
        }
        return mString;
    }

    private static String getLocaleStringResource(Context context, Locale requestedLocale, int resourceId, long param) {
        String result;
        Configuration config = new Configuration(context.getResources().getConfiguration());
        config.setLocale(requestedLocale);
        result = context.createConfigurationContext(config).getString(resourceId, param);
        return result;
    }
}
