package org.example.entities;

public class ClientParticulier extends Client {

    private Civilite civilite;
    private String nom;
    private String prenom;

    public ClientParticulier() {
    }

    public ClientParticulier(String referenceClient, Civilite civilite, String nom, String prenom) {
        super(referenceClient);
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    private static String validateReferenceClient(String referenceClient) {
        if (referenceClient.matches("EKW\\d{8}")) {
            return referenceClient;
        } else {
            throw new IllegalArgumentException("La référence client doit être au format EKW suivi de 8 caractères numériques.");
        }
    }
    {
    }
}