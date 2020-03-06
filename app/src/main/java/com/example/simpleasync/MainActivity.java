package com.example.simpleasync;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView mText;
    private static final String STATE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById (R.id.TextView);
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

        new SimpleAsyncTask (mText).execute ();
    }
}   //END OF CLASS
