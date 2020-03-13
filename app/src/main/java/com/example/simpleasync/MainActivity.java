package com.example.simpleasync;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    private TextView mText;
    private static final String STATE = "currentText";

    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById (R.id.TextView);
        pb = findViewById (R.id.progressBar);

        if (savedInstanceState != null)
        {
            mText.setText (savedInstanceState.getString(STATE));
        }
    }

    @Override
    protected void onSaveInstanceState (Bundle outState)
    {
        super.onSaveInstanceState (outState);
        outState.putString (STATE, mText.getText ().toString ());
    }

    public void startTask (View view)
    {
        mText.setText (R.string.napping);

        new SimpleAsyncTask (mText, pb).execute ();
    }
}   //END OF CLASS
