package com.example.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Locations extends AppCompatActivity {
    Button btn_viewL, btn_nearestH, btn_addL;

       private String date;
       private String time;
       private String venue;
       private String description;
       private String specialNotice;

       public Locations() {
           // Default constructor required for Firebase
       }

       public Locations(String date, String time, String venue, String description, String specialNotice) {
           this.date = date;
           this.time = time;
           this.venue = venue;
           this.description = description;
           this.specialNotice = specialNotice;
       }

       // Getters and setters (optional)

       public String getDate() {
           return date;
       }

       public void setDate(String date) {
           this.date = date;
       }

       public String getTime() {
           return time;
       }

       public void setTime(String time) {
           this.time = time;
       }

       public String getVenue() {
           return venue;
       }

       public void setVenue(String venue) {
           this.venue = venue;
       }

       public String getDescription() {
           return description;
       }

       public void setDescription(String description) {
           this.description = description;
       }

       public String getSpecialNotice() {
           return specialNotice;
       }

       public void setSpecialNotice(String specialNotice) {
           this.specialNotice = specialNotice;
       }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locations);

        btn_viewL = findViewById(R.id.btn_viewL);
        btn_nearestH = findViewById(R.id.btn_nearestH);
        btn_addL = findViewById(R.id.btn_addL);

        btn_viewL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  click for btn_viewL
                startActivity(new Intent(Locations.this,locationList.class));
            }
        });

        btn_nearestH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  click for btn_nearestH
                startActivity(new Intent(Locations.this, HospitalDetail.class));
            }
        });

        btn_addL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  click for btn_addL
                startActivity(new Intent(Locations.this, AddLocation.class));
            }
        });
    }
}

