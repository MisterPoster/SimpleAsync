package com.example.simpleasync;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Void, String>
{
    private WeakReference<TextView> mText;

    SimpleAsyncTask (TextView tv)
    {
        mText = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground (Void... voids)
    {
        Random a = new Random ();

        int n = a.nextInt (11);
        int i = n * 200;

        try
        {
            Thread.sleep (i);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace ();
        }

        return "Finally awake after sleeping " + i + " milliseconds!";
    }

    protected void onPostExecute (String res)
    {
        mText.get ().setText (res);
    }

}   //END OF CLASS
