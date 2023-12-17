package com.example.nour_bouguerra_mesure_gylcemie.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nour_bouguerra_mesure_gylcemie.R;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private Button retourButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        // Initialiser les éléments UI
        resultTextView = findViewById(R.id.resultTextView);
        retourButton = findViewById(R.id.retourButton);

        // Récupérer le texte de l'intent
        String resultAnalysis = getIntent().getStringExtra("resultAnalysis");

        // Afficher le résultat dans le TextView
        resultTextView.setText(resultAnalysis);

        // Configurer le listener pour le bouton Retour
        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Créer une Intent pour retourner à MainActivity
                Intent retourIntent = new Intent();
                setResult(RESULT_CANCELED, retourIntent);
                finish();
            }
        });
    }
}
