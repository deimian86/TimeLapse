package com.deimian86.timelapse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView1 = findViewById(R.id.txtView1);
        txtView1.setText(new TimeLapse().getLapse(getApplicationContext(), minutesAgo(5)));

        TextView txtView2 = findViewById(R.id.txtView2);
        txtView2.setText(new TimeLapse().getLapse(getApplicationContext(), minutesAgo(15)));

        TextView txtView3 = findViewById(R.id.txtView3);
        txtView3.setText(new TimeLapse().getLapse(getApplicationContext(), hoursAgo(1)));

        TextView txtView4 = findViewById(R.id.txtView4);
        txtView4.setText(new TimeLapse().getLapse(getApplicationContext(), hoursAgo(3)));

        TextView txtView5 = findViewById(R.id.txtView5);
        txtView5.setText(new TimeLapse().getLapse(getApplicationContext(), daysAgo(1)));

        TextView txtView6 = findViewById(R.id.txtView6);
        txtView6.setText(new TimeLapse().getLapse(getApplicationContext(), daysAgo(3)));

        TextView txtView7 = findViewById(R.id.txtView7);
        txtView7.setText(new TimeLapse().getLapse(getApplicationContext(), daysAgo(7)));

        TextView txtView8 = findViewById(R.id.txtView8);
        txtView8.setText(new TimeLapse().getLapse(getApplicationContext(), daysAgo(21)));
    }

    private Date daysAgo(int i) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -i);
        return cal.getTime();
    }

    private Date hoursAgo(int i) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -i);
        return cal.getTime();
    }

    private Date minutesAgo(int i) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -i);
        return cal.getTime();
    }
}
