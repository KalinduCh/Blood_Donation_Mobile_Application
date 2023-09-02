package com.example.questionnaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Questionnaire2 extends AppCompatActivity {
    private RadioButton question16_yes;
    private RadioButton question16_no;
    private RadioButton question17_yes;
    private RadioButton question17_no;
    private RadioButton question18_yes;
    private RadioButton question18_no;
    private RadioButton question19_yes;
    private RadioButton question19_no;

    private RadioButton question20_yes;
    private RadioButton question20_no;

    private RadioButton question21_yes;
    private RadioButton question21_no;

    private RadioButton question22_yes;
    private RadioButton question22_no;

    private RadioButton question23_yes;
    private RadioButton question23_no;

    private RadioButton question24_yes;
    private RadioButton question24_no;

    private RadioButton question25_yes;
    private RadioButton question25_no;

    private DatabaseReference questionnaireRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire2);

        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        questionnaireRef = database.getReference("questionnaire");

        question16_yes = findViewById(R.id.question16_yes);
        question16_no = findViewById(R.id.question16_no);

        question17_yes = findViewById(R.id.question17_yes);
        question17_no = findViewById(R.id.question17_no);

        question18_yes = findViewById(R.id.question18_yes);
        question18_no =findViewById(R.id.question18_no);

        question19_yes = findViewById(R.id.question19_yes);
        question19_no = findViewById(R.id.question19_no);

        question20_yes = findViewById(R.id.question20_yes);
        question20_no = findViewById(R.id.question20_no);

        question21_yes = findViewById(R.id.question21_yes);
        question21_no = findViewById(R.id.question21_no);

        question22_yes = findViewById(R.id.question22_yes);
        question22_no = findViewById(R.id.question22_no);

        question23_yes = findViewById(R.id.question23_yes);
        question23_no = findViewById(R.id.question23_no);

        question24_yes = findViewById(R.id.question24_yes);
        question24_no = findViewById(R.id.question24_no);

        question25_yes = findViewById(R.id.question25_yes);
        question25_no = findViewById(R.id.question25_no);




        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save questionnaire responses
                saveQuestionnaireResults();

                //  confirmation message
                Toast.makeText(getApplicationContext(), "Thank you for your response!", Toast.LENGTH_SHORT).show();

                // moving to next QU2
                startActivity(new Intent(Questionnaire2.this, UserProfile.class));
                finish();
            }
        });
    }

    private void saveQuestionnaireResults() {
        String question16Answer = question16_yes.isChecked() ? "Yes" : "No";
        String question17Answer = question17_yes.isChecked() ? "Yes" : "No";
        String question18Answer = question18_yes.isChecked() ? "Yes" : "No";
        String question19Answer = question19_yes.isChecked() ? "Yes" : "No";
        String question20Answer = question20_yes.isChecked() ? "Yes" : "No";
        String question21Answer = question21_yes.isChecked() ? "Yes" : "No";
        String question22Answer = question22_yes.isChecked() ? "Yes" : "No";
        String question23Answer = question23_yes.isChecked() ? "Yes" : "No";
        String question24Answer = question24_yes.isChecked() ? "Yes" : "No";
        String question25Answer = question25_yes.isChecked() ? "Yes" : "No";



        String key = questionnaireRef.push().getKey();
        questionnaireRef.child(key).child("Question16").setValue(question16Answer);
        questionnaireRef.child(key).child("Question17").setValue(question17Answer);
        questionnaireRef.child(key).child("Question18").setValue(question18Answer);
        questionnaireRef.child(key).child("Question19").setValue(question19Answer);
        questionnaireRef.child(key).child("Question20").setValue(question20Answer);
        questionnaireRef.child(key).child("Question21").setValue(question21Answer);
        questionnaireRef.child(key).child("Question22").setValue(question22Answer);
        questionnaireRef.child(key).child("Question23").setValue(question23Answer);
        questionnaireRef.child(key).child("Question24").setValue(question24Answer);
        questionnaireRef.child(key).child("Question25").setValue(question25Answer);

    }
}
