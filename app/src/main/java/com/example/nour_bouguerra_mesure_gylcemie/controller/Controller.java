package com.example.nour_bouguerra_mesure_gylcemie.controller;

import com.example.nour_bouguerra_mesure_gylcemie.model.Patient;

public class Controller {
    private static Controller instance;
    private static com.example.nour_bouguerra_mesure_gylcemie.model.Patient patient;

    // Rendre le constructeur privé pour empêcher l'instanciation directe
    private Controller() {
        super();
    }

    // Méthode statique pour obtenir l'instance unique du Controller
    public static final Controller getInstance() {
        if (instance == null)
            instance = new Controller();
        return instance;
    }

    // Mise à jour du Controller --> Model
    public void createPatient(int age, float valeurMesuree, boolean isFasting) {
        patient = new Patient(age, valeurMesuree, isFasting);
    }

    // Notify Model --> Controller
    public String getReponse() {
        return patient.getReponse();
    }
}
