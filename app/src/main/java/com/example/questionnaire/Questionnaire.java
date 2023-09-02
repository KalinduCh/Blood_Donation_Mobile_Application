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

public class Questionnaire extends AppCompatActivity {
    private RadioButton question1_yes;
    private RadioButton question1_no;
    private RadioButton question2_yes;
    private RadioButton question2_no;
    private RadioButton question3_yes;
    private RadioButton question3_no;
    private RadioButton question4_yes;
    private RadioButton question4_no;

    private RadioButton question5_yes;
    private RadioButton question5_no;

    private RadioButton question6_yes;
    private RadioButton question6_no;

    private RadioButton question7_yes;
    private RadioButton question7_no;

    private RadioButton question8_yes;
    private RadioButton question8_no;

    private RadioButton question9_yes;
    private RadioButton question9_no;

    private RadioButton question10_yes;
    private RadioButton question10_no;

    private RadioButton question11_yes;
    private RadioButton question11_no;

    private RadioButton question12_yes;
    private RadioButton question12_no;

    private RadioButton question13_yes;
    private RadioButton question13_no;

    private RadioButton question14_yes;
    private RadioButton question14_no;

    private RadioButton question15_yes;
    private RadioButton question15_no;

    // Add more variables for each question

    private DatabaseReference questionnaireRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        questionnaireRef = database.getReference("questionnaire");

        question1_yes = findViewById(R.id.question1_yes);
        question1_no = findViewById(R.id.question1_no);

        question2_yes = findViewById(R.id.question2_yes);
        question2_no = findViewById(R.id.question2_no);

        question3_yes = findViewById(R.id.question3_yes);
        question3_no=findViewById(R.id.question3_no);

        question4_yes = findViewById(R.id.question4_yes);
        question4_no = findViewById(R.id.question4_no);

        question5_yes = findViewById(R.id.question5_yes);
        question5_no = findViewById(R.id.question5_no);

        question6_yes = findViewById(R.id.question6_yes);
        question6_no = findViewById(R.id.question6_no);

        question7_yes = findViewById(R.id.question7_yes);
        question7_no = findViewById(R.id.question7_no);

        question8_yes = findViewById(R.id.question8_yes);
        question8_no = findViewById(R.id.question8_no);

        question9_yes = findViewById(R.id.question9_yes);
        question9_no = findViewById(R.id.question9_no);

        question10_yes = findViewById(R.id.question10_yes);
        question10_no = findViewById(R.id.question10_no);

        question11_yes = findViewById(R.id.question11_yes);
        question11_no = findViewById(R.id.question11_no);

        question12_yes = findViewById(R.id.question12_yes);
        question12_no = findViewById(R.id.question12_no);

        question13_yes = findViewById(R.id.question13_yes);
        question13_no = findViewById(R.id.question13_no);

        question14_yes = findViewById(R.id.question14_yes);
        question14_no = findViewById(R.id.question14_no);

        question15_yes = findViewById(R.id.question15_yes);
        question15_no = findViewById(R.id.question15_no);

        // Initialize variables for each question

        Button submitButton = findViewById(R.id.btn_save);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save questionnaire
                saveQuestionnaireResults();

                // confirmation message
                Toast.makeText(getApplicationContext(), "Thank you for your response!", Toast.LENGTH_SHORT).show();

                // moving to next QU2
                startActivity(new Intent(Questionnaire.this, Questionnaire2.class));
                finish();
            }
        });
    }

    private void saveQuestionnaireResults() {
        String question1Answer = question1_yes.isChecked() ? "Yes" : "No";
        String question2Answer = question2_yes.isChecked() ? "Yes" : "No";
        String question3Answer = question3_yes.isChecked() ? "Yes" : "No";
        String question4Answer = question4_yes.isChecked() ? "Yes" : "No";
        String question5Answer = "No";
        String question6Answer = "No";
        String question7Answer = question7_yes.isChecked() ? "Yes" : "No";
        String question8Answer = "No";
        String question9Answer = "No";
        String question10Answer = "No";
        String question11Answer = "No";
        String question12Answer = "No";
        String question13Answer = "No";
        String question14Answer = question14_yes.isChecked() ? "Yes" : "No";
        String question15Answer = "No";
        // QUESTION SET

        String key = questionnaireRef.push().getKey();
        questionnaireRef.child(key).child("Question1").setValue(question1Answer);
        questionnaireRef.child(key).child("Question2").setValue(question2Answer);
        questionnaireRef.child(key).child("Question3").setValue(question3Answer);
        questionnaireRef.child(key).child("Question4").setValue(question4Answer);
        questionnaireRef.child(key).child("Question5").setValue(question5Answer);
        questionnaireRef.child(key).child("Question6").setValue(question6Answer);
        questionnaireRef.child(key).child("Question7").setValue(question7Answer);
        questionnaireRef.child(key).child("Question8").setValue(question8Answer);
        questionnaireRef.child(key).child("Question9").setValue(question9Answer);
        questionnaireRef.child(key).child("Question10").setValue(question10Answer);
        questionnaireRef.child(key).child("Question11").setValue(question11Answer);
        questionnaireRef.child(key).child("Question12").setValue(question12Answer);
        questionnaireRef.child(key).child("Question13").setValue(question13Answer);
        questionnaireRef.child(key).child("Question14").setValue(question14Answer);
        questionnaireRef.child(key).child("Question15").setValue(question15Answer);

        // ANSWER SAVING
    }
}
