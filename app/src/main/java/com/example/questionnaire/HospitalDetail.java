package com.example.questionnaire;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class HospitalDetail extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextAddress;
    private Button buttonInsert;
    private EditText editTextSearch;
    private Button buttonFilter;
    private Button buttonView;
    private ListView listViewHospitals;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private List<Hospital> hospitalList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        // Initialize Firebase
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("hospitals");

        hospitalList = new ArrayList<>();

        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonInsert = findViewById(R.id.buttonInsert);
        editTextSearch = findViewById(R.id.editTextSearch);
        buttonFilter = findViewById(R.id.buttonFilter);
        buttonView = findViewById(R.id.buttonView);
        listViewHospitals = findViewById(R.id.listViewHospitals);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();

                if (!name.isEmpty() && !address.isEmpty()) {
                    String hospitalId = databaseReference.push().getKey();
                    Hospital hospital = new Hospital(hospitalId, name, address);
                    databaseReference.child(hospitalId).setValue(hospital);
                    editTextName.setText("");
                    editTextAddress.setText("");
                }
            }
        });

        buttonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = editTextSearch.getText().toString().trim();
                filterHospitals(searchQuery);
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        hospitalList.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Hospital hospital = snapshot.getValue(Hospital.class);
                            hospitalList.add(hospital);
                        }
                        populateListView(hospitalList);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle database error
                    }
                });
            }
        });
    }

    private void filterHospitals(String searchQuery) {
        List<Hospital> filteredList = new ArrayList<>();
        for (Hospital hospital : hospitalList) {
            if (hospital.getName().toLowerCase().contains(searchQuery.toLowerCase())) {
                filteredList.add(hospital);
            }
        }
        populateListView(filteredList);
    }

    private void populateListView(List<Hospital> hospitals) {
        List<String> hospitalNames = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            hospitalNames.add(hospital.getName() + ", " + hospital.getAddress());
        }
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hospitalNames);
        listViewHospitals.setAdapter(arrayAdapter);
    }
}

