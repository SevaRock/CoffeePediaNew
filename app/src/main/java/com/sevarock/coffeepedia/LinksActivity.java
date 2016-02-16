package com.sevarock.coffeepedia;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class LinksActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        //Custom Fonts Applying
        TextView customViewTop = (TextView) findViewById(R.id.LinksActivityHeader);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/docktrin.ttf");
        customViewTop.setTypeface(myCustomFont);

    }
}
