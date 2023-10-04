package org.example.entities;

public enum TypeEnergie {

    ELEC("Electricité"),
    GAZ("Gaz");

    private final String libelle;

    TypeEnergie(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}