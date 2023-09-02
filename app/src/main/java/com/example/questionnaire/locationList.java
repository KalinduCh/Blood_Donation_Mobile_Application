package com.example.questionnaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class locationList extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    LAdapter lAdapter;
    ArrayList<Location>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        recyclerView = findViewById(R.id.locationList);
        database = FirebaseDatabase.getInstance().getReference("Locations");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        lAdapter = new LAdapter(this,list);
        recyclerView.setAdapter(lAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Location location = dataSnapshot.getValue(Location.class);
                    list.add(location);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}