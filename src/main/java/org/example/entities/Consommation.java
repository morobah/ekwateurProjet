package org.example.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Consommation {

    private List<LigneConsommation> lignesConsommation;

    public Consommation() {
        this.lignesConsommation = new ArrayList<>();
    }

    public List<LigneConsommation> getLignesConsommation() {
        return lignesConsommation;
    }

    public void ajouterLigneConsommation(LigneConsommation ligneConsommation) {
        this.lignesConsommation.add(ligneConsommation);
    }

    public static class LigneConsommation {

        private BigDecimal quantite;
        private Energie energie;

        public LigneConsommation(BigDecimal quantite, Energie energie) {
            this.quantite = quantite;
            this.energie = energie;
        }

        public BigDecimal getQuantite() {
            return quantite;
        }

        public void setQuantite(BigDecimal quantite) {
            this.quantite = quantite;
        }

        public Energie getEnergie() {
            return energie;
        }

        public void setEnergie(Energie energie) {
            this.energie = energie;
        }
    }
}
