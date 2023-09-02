package com.example.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {

    private ImageView profileImage;
    private Button uploadButton;
    private Button delete_button;
    private Button save_button;
    private EditText fullNameEditText;
    private Spinner genderSpinner;
    private EditText dateOfBirthEditText;
    private Spinner maritalStatusSpinner;
    private EditText nationalityEditText;
    private EditText mobileNumberEditText;
    private EditText addressEditText;
    private EditText districtEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Initialize views
        profileImage = findViewById(R.id.profile_image);
        uploadButton = findViewById(R.id.upload_button);
        save_button=findViewById(R.id.save_button);
        delete_button=findViewById(R.id.delete_button);
        fullNameEditText = findViewById(R.id.full_name_edittext);
        genderSpinner = findViewById(R.id.gender_spinner);
        dateOfBirthEditText = findViewById(R.id.date_of_birth_edittext);
        maritalStatusSpinner = findViewById(R.id.marital_status_spinner);
        nationalityEditText = findViewById(R.id.nationality_edittext);
        mobileNumberEditText = findViewById(R.id.mobile_number_edittext);
        addressEditText = findViewById(R.id.address_edittext);
        districtEditText = findViewById(R.id.district_edittext);

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfile.this, Locations.class));
            }
        });
    }
}
