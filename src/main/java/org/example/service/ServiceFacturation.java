package org.example.service;

import org.example.entities.*;
import java.math.BigDecimal;

public class ServiceFacturation {

    public BigDecimal calculerMontantConsommation(Client client, Consommation consommation) {
        BigDecimal montantTotal = BigDecimal.ZERO;

        if (client instanceof ClientParticulier || client instanceof ClientPro) {
            for (Consommation.LigneConsommation ligne : consommation.getLignesConsommation()) {
                Energie energie = ligne.getEnergie();
                BigDecimal quantite = ligne.getQuantite();
                BigDecimal prixKwh = getPrixKwh(client, energie);

                BigDecimal montantLigne = quantite.multiply(prixKwh);
                montantTotal = montantTotal.add(montantLigne);
            }
        }

        return montantTotal;
    }

    private BigDecimal getPrixKwh(Client client, Energie energie) {
        if (client instanceof ClientParticulier) {
            if (energie.getType().equals(TypeEnergie.ELEC.getLibelle())) {
                return new BigDecimal("0.121");
            } else if (energie.getType().equals(TypeEnergie.GAZ.getLibelle())) {
                return new BigDecimal("0.115");
            }
        } else if (client instanceof ClientPro) {
            ClientPro clientPro = (ClientPro) client;
            if (clientPro.getCa() > 1000000) {
                if (energie.getType().equals(TypeEnergie.ELEC.getLibelle())) {
                    return new BigDecimal("0.114");
                } else if (energie.getType().equals(TypeEnergie.GAZ.getLibelle())) {
                    return new BigDecimal("0.111");
                }
            } else {
                if (energie.getType().equals(TypeEnergie.ELEC.getLibelle())) {
                    return new BigDecimal("0.118");
                } else if (energie.getType().equals(TypeEnergie.GAZ.getLibelle())) {
                    return new BigDecimal("0.113");
                }
            }
        }
        return BigDecimal.ZERO; // Retourne 0 en cas de conditions non satisfaites ou type de client non reconnu
    }
}
