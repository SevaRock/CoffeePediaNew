package com.sevarock.coffeepedia;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.net.URI;

public class ListOfDrinks extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_drinks);

        //Buttons Listeners
        Button capuccino = (Button) findViewById(R.id.capuccino);
        capuccino.setOnClickListener(this);
        Button americano = (Button) findViewById(R.id.americano);
        americano.setOnClickListener(this);
        Button espresso = (Button) findViewById(R.id.Espresso);
        espresso.setOnClickListener(this);
        Button macchiato = (Button) findViewById(R.id.Macchiato);
        macchiato.setOnClickListener(this);

        //Custom Fonts Applying
        TextView customViewTop = (TextView) findViewById(R.id.ListHeader);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/docktrin.ttf");
        customViewTop.setTypeface(myCustomFont);

    }


    @Override
    public void onClick (View v) {

        final Intent coffeeArticle = new Intent(this, CoffeeBeverageArticle.class);

        switch (v.getId()) {

            case R.id.capuccino:
                coffeeArticle.putExtra("header", "Capuccino");
                //TODO говно какое-то блять c подстановкой image uri. Нужно сделать более вменяемо. Потом.
                Uri capuccinoUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getResources()
                                .getResourcePackageName(R.drawable.cappucinoarticle) + '/' + getResources().
                        getResourceTypeName(R.drawable.cappucinoarticle) + '/' + String.valueOf(R.drawable.cappucinoarticle));
                coffeeArticle.putExtra("image", capuccinoUri);
                coffeeArticle.putExtra("body", getResources().getResourceName(R.raw.cappucino));
                startActivity(coffeeArticle);
                break;

            case R.id.americano:
                coffeeArticle.putExtra("header", "Americano");
                Uri americanoUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getResources()
                        .getResourcePackageName(R.drawable.americanoart) + '/' + getResources().
                        getResourceTypeName(R.drawable.americanoart) + '/' + String.valueOf(R.drawable.americanoart));
                coffeeArticle.putExtra("body", getResources().getResourceName(R.raw.americano));
                coffeeArticle.putExtra("image", americanoUri);
                startActivity(coffeeArticle);
                break;

            case R.id.Espresso:
                coffeeArticle.putExtra("header", "Espresso");
                Uri EspressoUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getResources()
                        .getResourcePackageName(R.drawable.espressoart) + '/' + getResources().
                        getResourceTypeName(R.drawable.espressoart) + '/' + String.valueOf(R.drawable.espressoart));
                coffeeArticle.putExtra("body", getResources().getResourceName(R.raw.espresso));
                coffeeArticle.putExtra("image" , EspressoUri);
                startActivity(coffeeArticle);
                break;

            case R.id.Macchiato:
                coffeeArticle.putExtra("header" , "Macchiato");
                Uri MachiatoUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getResources()
                        .getResourcePackageName(R.drawable.macchiato) + '/' + getResources().
                        getResourceTypeName(R.drawable.macchiato) + '/' + String.valueOf(R.drawable.macchiato));
                coffeeArticle.putExtra("body", getResources().getResourceName(R.raw.machiatto));
                coffeeArticle.putExtra("image" , MachiatoUri);
                startActivity(coffeeArticle);
                break;

        }



    }
}
