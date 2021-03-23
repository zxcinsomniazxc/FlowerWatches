package com.example.flowerwatches;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityProfile extends AppCompatActivity {

    ImageView favwhite, mainpagewhite, profilewhite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);

        favwhite = (ImageView)findViewById(R.id.favwhite);
        mainpagewhite = (ImageView)findViewById(R.id.mainpagewhite);
        profilewhite = (ImageView)findViewById(R.id.profilewhite);
    }

    public void onClickMainPage (View view) {
        Intent i = new Intent(MainActivityProfile.this, MainActivity.class);
        startActivity(i);
    }


    public void onClickFav (View view) {
        Intent i = new Intent(MainActivityProfile.this, MainActivityFav.class);
        startActivity(i);
    }

    public void onClickProfile (View view) {
        Intent i = new Intent(MainActivityProfile.this, MainActivityProfile.class);
        startActivity(i);
    }

}