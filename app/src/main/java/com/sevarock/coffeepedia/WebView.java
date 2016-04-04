package com.sevarock.coffeepedia;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WebView extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
    }

}




