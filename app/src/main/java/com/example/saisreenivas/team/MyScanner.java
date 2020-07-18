package com.example.saisreenivas.team;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Sai sreenivas on 10/26/2016.
 */

public class MyScanner extends MainActivity implements ZXingScannerView.ResultHandler {

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qrscanner:
                mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view<br />
                setContentView(mScannerView);
                mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.<br />
                mScannerView.startCamera();         // Start camera<br /
            case R.id.history:
                Intent intent = new Intent(this, History.class);
                TextView editText = (TextView) findViewById(R.id.history);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
        }
    }

    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.e("handler", rawResult.getText());//prints scan results
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)
        // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        builder.setCancelable(true);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www..com"));
                Bundle b = new Bundle();
                b.putBoolean("new_window", true); //sets new window
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        final AlertDialog alert1 = builder.create();
        alert1.show();
        // If you would like to resume scanning after 5 seconds, call this method below:<br />
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                alert1.dismiss();
                mScannerView.resumeCameraPreview(MyScanner.this);
            }
        }, 5000);
    }
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();   // Stop camera on pause<br />
    }
}
