package com.example.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    private Button btnLogout;
    private Button btnDonateNow;
    private Button btnFindDonors;
    private Button btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        btnLogout = findViewById(R.id.btnMyProf);
        btnDonateNow = findViewById(R.id.btnDonateNow);
        btnFindDonors = findViewById(R.id.btnFindDonors);
        btnLocation = findViewById(R.id.btnLocation);

        // click listeners
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Home.this, "Logout clicked", Toast.LENGTH_SHORT).show();

            }
        });

        btnDonateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Home.this, "Donate Now clicked", Toast.LENGTH_SHORT).show();
                //  donate now
                Intent intent = new Intent(Home.this, Questionnaire.class);
                startActivity(intent);
            }
        });

        btnFindDonors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  find donors
                Toast.makeText(Home.this, "Find Donors clicked", Toast.LENGTH_SHORT).show();
                // Add  donors
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle location button click
                Toast.makeText(Home.this, "Location clicked", Toast.LENGTH_SHORT).show();
                // Add your location logic here
                // Start MainActivity
                Intent intent = new Intent(Home.this, Locations.class);
                startActivity(intent);
            }
        });

        // Add your logic for notices and slideshow
    }
}
