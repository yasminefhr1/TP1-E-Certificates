package com.fihriyasmine.e_certificates;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private CheckBox rps11, rps12, rps13, rps14;
    private RadioGroup radioGroup;
    private RadioButton selectedRadioButton;
    private Button suivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rps11 = findViewById(R.id.rps11);
        rps12 = findViewById(R.id.rps12);
        rps13 = findViewById(R.id.rps13);
        rps14 = findViewById(R.id.rps14);
        radioGroup = findViewById(R.id.radiogroup);

        suivant = findViewById(R.id.Suivant);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> question1Responses = new ArrayList<>();

                if (rps11.isChecked()) question1Responses.add(rps11.getText().toString());
                if (rps12.isChecked()) question1Responses.add(rps12.getText().toString());
                if (rps13.isChecked()) question1Responses.add(rps13.getText().toString());
                if (rps14.isChecked()) question1Responses.add(rps14.getText().toString());

                int selectedRadioId = radioGroup.getCheckedRadioButtonId();
                selectedRadioButton = findViewById(selectedRadioId);
                String question2Response = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "Pas de réponse";

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putStringArrayListExtra("question1_responses", question1Responses);
                intent.putExtra("question2_response", question2Response);
                startActivity(intent);
            }
        });
    }
}