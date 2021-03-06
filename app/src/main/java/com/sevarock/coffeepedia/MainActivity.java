package com.sevarock.coffeepedia;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.coffeelogo);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorDarkCoffee));
        setSupportActionBar(toolbar);

        //Custom Fonts Applying
        TextView customViewTop = (TextView) findViewById(R.id.welcomeText);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/docktrin.ttf");
        customViewTop.setTypeface(myCustomFont);

        //Test Button Font Applying
        Button customButton1 = (Button) findViewById(R.id.ButtonSorts);
        customButton1.setTypeface(myCustomFont);

        Button customButton2 = (Button) findViewById(R.id.ButtonVarieties);
        customButton2.setTypeface(myCustomFont);

        Button customButton3 = (Button) findViewById(R.id.CappucinoArtButton);
        customButton3.setTypeface(myCustomFont);

        Button customButton4 = (Button) findViewById(R.id.LinksButton);
        customButton4.setTypeface(myCustomFont);

        Button customButton5 = (Button) findViewById(R.id.MapButton);
        customButton5.setTypeface(myCustomFont);

        Button customButton6 = (Button) findViewById(R.id.WebContent);
        customButton6.setTypeface(myCustomFont);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.about) {
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void listClick (View view) {
        Intent listClick = new Intent(this, ListOfDrinks.class);
        startActivity(listClick);
    }

    public void aboutClick (MenuItem item) {
        Intent aboutClick = new Intent(this, About.class);
        startActivity(aboutClick);
    }

    public void cameraClick (MenuItem item) {
        Intent launchCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(launchCamera, CONTEXT_INCLUDE_CODE);
    }

    public void LatteGallery (View view) {
        Intent LatteGalleryClick = new Intent(this, LatteArtGallery.class);
        startActivity(LatteGalleryClick);
    }

    public void LatteGalleryMenu (MenuItem view) {
        Intent LatteGalleryClick = new Intent(this, LatteArtGallery.class);
        startActivity(LatteGalleryClick);
    }

    public void linksClick (View view) {
        Intent linksClickActivity = new Intent(this, LinksActivity.class);
        startActivity(linksClickActivity);
    }

    public void varietiesClick (View view) {
        Intent varietiesClickActivity = new Intent(this, VarietiesActivity.class);
        startActivity(varietiesClickActivity);
    }

    public void webContentClick (View view) {
        Intent webContentClickActivity = new Intent(this, WebView.class);
        startActivity(webContentClickActivity);
    }

    public void mapClick (View view) {
        //TODO сделать чтобы искало кофейни около твоего местоположения
        String geoUriString = "geo:0,0?q=moscow+coffee+shops&z=8";
        Uri geoUri = Uri.parse(geoUriString);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
        startActivity(mapIntent);

    }


}
