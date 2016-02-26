package com.sevarock.coffeepedia;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class CoffeeBeverageArticle extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_beverage_article);

        String Header = getIntent().getStringExtra("header");
        TextView ArtHeader = (TextView) findViewById(R.id.ArticleHeaderText);
        ArtHeader.setText(Header);

        Uri ArtImage = getIntent().getParcelableExtra("image");
        ImageView ArticleImage = (ImageView) findViewById(R.id.ArticleHeaderImage);
        ArticleImage.setImageURI(ArtImage);

        //Custom Fonts Applying
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/docktrin.ttf");
        ArtHeader.setTypeface(myCustomFont);

        //Импорт текста из RAW ресурсов
        Context context = getBaseContext();
        WebView ArtBody = (WebView) findViewById(R.id.ArticleBody);
        ArtBody.getSettings();
        ArtBody.setBackgroundColor(Color.parseColor("#BA7C50"));
        //Хороший (?) пример форматирования html текста внутри WebView
        String textStyle = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String resName = getIntent().getStringExtra("body");
        String article = readRawTextFile(context, getResources().getIdentifier(resName, "raw", "com.sevarock.coffeepedia"));
        ArtBody.loadData(String.format(textStyle ,article), "text/html", "utf-8");
    }

    //Чтение текста из ресурсов
    //TODO Нормально отредактировать хуево отображающиеся текста в ресурсах
    public static String readRawTextFile(Context context, int resId)
    {
        InputStream inputStream = context.getResources().openRawResource(resId);

        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader buffReader = new BufferedReader(inputReader);
        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while (( line = buffReader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
    }
}