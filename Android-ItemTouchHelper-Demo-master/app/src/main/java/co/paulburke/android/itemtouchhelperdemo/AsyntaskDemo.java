package co.paulburke.android.itemtouchhelperdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import co.paulburke.android.itemtouchhelperdemo.asyntask.MyAsyntask;

public class AsyntaskDemo extends AppCompatActivity implements OnSuccessListner {
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntask_demo);

        printTest(1, "print");
        MyAsyntask myAsyntask = new MyAsyntask(AsyntaskDemo.this);
        myAsyntask.execute();

        printTest(2, "hello");


    }


    public void printTest(int pos, String arg) {
        Log.v("Print " + pos, arg);
    }

    @Override
    public void onSuccess(boolean flag) {
        Toast.makeText(AsyntaskDemo.this, "finished", Toast.LENGTH_LONG).show();
        mProgressDialog.setMessage("Thread is completed");
        mProgressDialog.dismiss();
    }

    @Override
    public void onError() {

    }

    @Override
    public void onPrepare() {


        mProgressDialog = new ProgressDialog(AsyntaskDemo.this);
        mProgressDialog.setMessage("Backgound thread is about to start");
        mProgressDialog.show();

    }


}
