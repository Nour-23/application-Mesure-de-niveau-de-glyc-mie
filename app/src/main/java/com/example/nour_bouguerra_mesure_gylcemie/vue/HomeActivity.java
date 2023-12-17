package com.example.nour_bouguerra_mesure_gylcemie.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nour_bouguerra_mesure_gylcemie.R;
import com.example.nour_bouguerra_mesure_gylcemie.controller.LoginController;

public class HomeActivity extends AppCompatActivity {

    private Button btnConsultation;
    private LoginController loginController;
    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        // Initialisation des propriétés dans la méthode onCreate
        btnConsultation = findViewById(R.id.btnConsultation);
        etUsername = findViewById(R.id.nom); // Ajout du champ pour le nom d'utilisateur
        etPassword = findViewById(R.id.mdp); // Ajout du champ pour le mot de passe

        // Initialize LoginController instance
        loginController = LoginController.getInstance();

        // Example: Création d'un utilisateur lors du premier accès
        if (!loginController.isUserCreated()) {
            btnConsultation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Récupérer le nom d'utilisateur et le mot de passe saisis
                    String username = etUsername.getText().toString();
                    String password = etPassword.getText().toString();

                    // Créer un nouvel utilisateur
                    loginController.createUser(username, password, HomeActivity.this);

                    // Lancer l'activité MainActivity
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            // Si l'utilisateur est déjà créé, lancer directement MainActivity
            btnConsultation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
