package com.deimian86.timelapse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.deimian86.timelapse.library.TimeLapse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = (TextView) findViewById(R.id.txtView);
        txtView.setText(new TimeLapse().helloWorld());
    }
}
