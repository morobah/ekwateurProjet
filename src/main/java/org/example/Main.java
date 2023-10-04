package org.example;


import org.example.entities.*;
import org.example.service.ServiceFacturation;

import java.math.BigDecimal;

public class Main {

            public static void main(String[] args) {

            ClientParticulier clientParticulier = new ClientParticulier("EKW12345678", Civilite.M, "Dupont", "Jean");
            Energie energie = new Energie(TypeEnergie.ELEC.getLibelle(), new BigDecimal("100"));
            Consommation.LigneConsommation ligne = new Consommation.LigneConsommation(new BigDecimal("100"), energie);
            Consommation consommation = new Consommation();
            consommation.ajouterLigneConsommation(ligne);
            BigDecimal montantAttendu = new BigDecimal("12.10");
                ServiceFacturation serviceFacturation = new ServiceFacturation();
                BigDecimal montantCalcule = serviceFacturation.calculerMontantConsommation(clientParticulier, consommation);

            System.out.println("Client particulier :");
            System.out.println("  Nom : " + clientParticulier.getNom());
            System.out.println("  Prénom : " + clientParticulier.getPrenom());
            System.out.println("  Consommation :");
            System.out.println("    Électricité : " + ligne.getQuantite() + " kWh");
            System.out.println("");
            System.out.println("Montant de la facture : " + montantCalcule);


            ClientPro clientPro = new ClientPro("EKW98765432", "789123456", "Entreprise ABC", 500000L);
            Energie energiePro = new Energie(TypeEnergie.ELEC.getLibelle(), new BigDecimal("50"));
            Consommation.LigneConsommation lignePro = new Consommation.LigneConsommation(new BigDecimal("50"), energiePro);
            Consommation consommationPro = new Consommation();
            consommationPro.ajouterLigneConsommation(lignePro);

            BigDecimal montantAttenduPro = new BigDecimal("5.90");
            BigDecimal montantCalculePro = serviceFacturation.calculerMontantConsommation(clientPro, consommationPro);

            System.out.println("Client professionnel :");
            System.out.println("  Nom : " + clientPro.getRaisonSociale());
            System.out.println("  Siret : " + clientPro.getSiret());
            System.out.println("  Consommation :");
            System.out.println("    Électricité : " + lignePro.getQuantite() + " kWh");
            System.out.println("");
            System.out.println("Montant de la facture : " + montantCalculePro);

            ClientPro clientPro2 = new ClientPro("EKW65432109", "987654321", "Entreprise DEF", 1000000L);
            Energie energiePro2 = new Energie(TypeEnergie.ELEC.getLibelle(), new BigDecimal("100"));
            Consommation.LigneConsommation lignePro2 = new Consommation.LigneConsommation(new BigDecimal("100"), energiePro2);
            Consommation consommationPro2 = new Consommation();
            consommationPro2.ajouterLigneConsommation(lignePro2);

            BigDecimal montantAttenduPro2 = new BigDecimal("11.40");
            BigDecimal montantCalculePro2 = serviceFacturation.calculerMontantConsommation(clientPro2, consommationPro2);

            System.out.println("Client professionnel :");
            System.out.println("  Nom : " + clientPro2.getRaisonSociale());
            System.out.println("  Siret : " + clientPro2.getSiret());
            System.out.println("  Consommation :");
            System.out.println("    Électricité : " + lignePro2.getQuantite() + " kWh");
            System.out.println("");
            System.out.println("Montant de la facture : " + montantCalculePro2);
        }
    }
