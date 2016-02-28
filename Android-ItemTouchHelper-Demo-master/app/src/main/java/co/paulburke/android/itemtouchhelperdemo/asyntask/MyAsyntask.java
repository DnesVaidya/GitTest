package co.paulburke.android.itemtouchhelperdemo.asyntask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import co.paulburke.android.itemtouchhelperdemo.OnSuccessListner;

/**
 * Created by Dns on 2/28/2016.
 */
public class MyAsyntask extends AsyncTask<String, Void, Boolean> {
    OnSuccessListner onSuccessListner;

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return true;
        }
    });

    public MyAsyntask(Context context) {

        onSuccessListner = (OnSuccessListner) context;

    }


    @Override
    protected void onPreExecute() {
        onSuccessListner.onPrepare();
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(String... voids) {
        Log.v("asyn", "asyntassk is running");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.handleMessage(null);
            }
        }, 5000);

        return false;
    }


    @Override
    protected void onPostExecute(Boolean isComplete) {
        super.onPostExecute(isComplete);
        Log.v("asyn", "asyntassk is Completed");

        if (isComplete) {
            onSuccessListner.onSuccess(isComplete);

        } else {
            onSuccessListner.onError();
        }

    }


   /* Handler mHandler=new Handler(new Handler.Callback() {
    })*/
}
