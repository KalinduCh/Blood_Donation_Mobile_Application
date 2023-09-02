package com.example.questionnaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class AddLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        final EditText edit_date = findViewById(R.id.editTextDate);
        final EditText edit_Id = findViewById(R.id.edit_locationId);
        final EditText edit_time = findViewById(R.id.editTextTime);
        final EditText edit_venue = findViewById(R.id.editTextVenue);
        final EditText edit_description = findViewById(R.id.editTextDescription);
        final EditText edit_notice = findViewById(R.id.editTextSpecialNotice);

        Button btn_post = findViewById(R.id.buttonPost);
        Button btn_delete = findViewById(R.id.buttonDelete);
        Button btn_update = findViewById(R.id.buttonUpdateD);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference();

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getDate = edit_date.getText().toString();
                String getId = edit_Id.getText().toString();
                String getTime = edit_time.getText().toString();
                String getVenue = edit_venue.getText().toString();
                String getDescription = edit_description.getText().toString();
                String getNotice = edit_notice.getText().toString();

                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("date", getDate);
                hashMap.put("id", getId);
                hashMap.put("time", getTime);
                hashMap.put("venue", getVenue);
                hashMap.put("description", getDescription);
                hashMap.put("notice", getNotice);

                databaseReference.child("Locations")
                        .child(getId)
                        .setValue(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(AddLocation.this, "Location Added", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddLocation.this, "Failed to add location: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getId = edit_Id.getText().toString();

                databaseReference.child("Locations")
                        .child(getId)
                        .removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(AddLocation.this, "Location Deleted", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddLocation.this, "Failed to delete location: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getDate = edit_date.getText().toString();
                String getId = edit_Id.getText().toString();
                String getTime = edit_time.getText().toString();
                String getVenue = edit_venue.getText().toString();
                String getDescription = edit_description.getText().toString();
                String getNotice = edit_notice.getText().toString();

                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("date", getDate);
                hashMap.put("id", getId);
                hashMap.put("time", getTime);
                hashMap.put("venue", getVenue);
                hashMap.put("description", getDescription);
                hashMap.put("notice", getNotice);

                databaseReference.child("Locations")
                        .child(getId)
                        .updateChildren(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(AddLocation.this, "Location Updated", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddLocation.this, "Failed to update location: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}