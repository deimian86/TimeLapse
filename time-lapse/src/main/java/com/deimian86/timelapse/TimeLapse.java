package com.deimian86.timelapse;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by deimian86 on 19/07/2017.
 */
public class TimeLapse {

    public String getLapse(Context context, Date fechaInicial) {
        String cadena = "";
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fechaActual = new Date();
        formatoDelTexto.format(fechaActual);
        // Tenemos la fecha inicial y la actual ahora operamos con ellas
        long diff = fechaActual.getTime() - fechaInicial.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        // Formateamos la cadena
        if (diffDays == 0) {
            if (diffHours == 0) {
                if (diffMinutes < 10) {
                    cadena = context.getResources().getString(R.string.lapse_moments_ago);
                } else {
                    cadena = context.getResources().getString(R.string.lapse_minutes_ago, diffMinutes);
                }
            } else if (diffHours == 1) {
                cadena = context.getResources().getString(R.string.lapse_hour_ago, diffHours);
            } else if (diffHours > 1) {
                cadena = context.getResources().getString(R.string.lapse_hours_ago, diffHours);
            }
        } else if (diffDays == 1) {
            cadena = context.getResources().getString(R.string.lapse_day_ago, diffDays);
        } else if (diffDays > 1 && diffDays < 7) {
            cadena = context.getResources().getString(R.string.lapse_days_ago, diffDays);
        } else if (diffDays == 7) {
            cadena = context.getResources().getString(R.string.lapse_week_ago);
        } else if (diffDays > 7 && diffDays < 14) {
            cadena = context.getResources().getString(R.string.lapse_days_ago, diffDays);
        } else if (diffDays == 14) {
            cadena = context.getResources().getString(R.string.lapse_weeks_ago);
        } else if (diffDays > 14) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            cadena = formato.format(fechaInicial);
        }
        return cadena;
    }
}
