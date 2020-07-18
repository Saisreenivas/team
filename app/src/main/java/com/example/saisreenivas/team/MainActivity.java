package com.example.saisreenivas.team;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity {
    Button feedback;
    MyListener listener = new MyListener();
    MyScanner Scanner = new MyScanner();
    Button qrscanner;
    Button history;

    ZXingScannerView mScannerView;
    public final static String EXTRA_MESSAGE = "com.example.saisreenivas.MESSAGE";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedback = (Button) findViewById(R.id.feedback);
        qrscanner = (Button) findViewById(R.id.qrscanner);
        history = (Button) findViewById(R.id.history);
        //feedback.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        startActivity(new Intent(MainActivity.this, Feedback.class));
        //
        //    }
        //});


        //the same can also be written as feedback.setOnClickListener(this);
        //public void onClick(View v) {
        //switch (v.getId()) {
        //   case R.id.imageButton1:
        //        startActivity(new Intent(getApplicationContext(), open.class));
        //        break;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.feedback:
                listener.onClick(feedback);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void QrScanner(View view) {
        Scanner.onClick(qrscanner);
    }


    public void history(View view) {
        Scanner.onClick(history);
    }

    @Override
    public void onPause() {
        Scanner.onPause();
    }

    public void clickMe(View v) {
        Button button = (Button) v;
        button.setText("I have been Clicked!");
        Button myhistory = (Button) findViewById(R.id.history);
        myhistory.setText("you clicked my button");
    }
}
