package com.example.simpleasync;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.*;
import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Integer, String>
{
    private WeakReference<TextView> mText;
    private WeakReference<ProgressBar> mPb;
    private static int CHUNK_SIZE = 5;

    SimpleAsyncTask (TextView tv, ProgressBar pb)
    {
        mText = new WeakReference<>(tv);
        mPb = new WeakReference<>(pb);
    }

    @Override
    protected String doInBackground (Void... voids)
    {
        Random a = new Random ();

        int n = a.nextInt (11);
        int mil = n * 200;

        int chunk_size = mil / CHUNK_SIZE;

        for (int j = 0; j < CHUNK_SIZE; j++)
        {
            try
            {
                Thread.sleep (chunk_size);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace ();
            }

            publishProgress (((j + 1) * 100) / CHUNK_SIZE);
        }

        return "Finally awake after sleeping " + mil + " milliseconds!";
    }

    @Override
    protected void onProgressUpdate (Integer... values)
    {
        mPb.get ().setProgress (values[0]);
    }

    protected void onPostExecute (String res)
    {
        mText.get ().setText (res);
    }

}   //END OF CLASS
