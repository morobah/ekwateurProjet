package org.example.entities;

public enum Civilite {

    M("Monsieur"),
    MME("Madame"),
    MLLE("Mademoiselle");

    private final String libelle;

    Civilite(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}



