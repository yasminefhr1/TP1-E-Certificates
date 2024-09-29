package com.fihriyasmine.e_certificates;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    private TextView resultQ1, resultQ2;
    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        resultQ1 = findViewById(R.id.rp1);
        resultQ2 = findViewById(R.id.rp2);
        goBack = findViewById(R.id.goback);


        Intent intent = getIntent();
        ArrayList<String> question1Responses = intent.getStringArrayListExtra("question1_responses");
        String question2Response = intent.getStringExtra("question2_response");


        if (question1Responses != null && !question1Responses.isEmpty()) {
            StringBuilder q1ResponseBuilder = new StringBuilder();
            for (String response : question1Responses) {
                q1ResponseBuilder.append(response).append("\n");
            }
            resultQ1.setText(q1ResponseBuilder.toString());
        } else {
            resultQ1.setText("Pas de réponse");
        }


        resultQ2.setText(question2Response);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}