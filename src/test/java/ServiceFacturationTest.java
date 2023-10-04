import org.example.entities.*;
import org.example.service.ServiceFacturation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceFacturationTest {

    private ServiceFacturation serviceFacturation;

    @BeforeEach
    public void setUp() {
        serviceFacturation = new ServiceFacturation();
    }
    @Test
    public void testCalculerMontantConsommationParticulier() throws NumberFormatException {
        ClientParticulier client = new ClientParticulier("EKW12345678", Civilite.M, "Dupont", "Jean");
        Energie energie = new Energie("Electricité", new BigDecimal("100"));
        Consommation.LigneConsommation ligne = new Consommation.LigneConsommation(new BigDecimal("100"), energie);
        Consommation consommation = new Consommation();
        consommation.ajouterLigneConsommation(ligne);

        BigDecimal montantAttendu = new BigDecimal("12.100");
        BigDecimal montantCalculé = serviceFacturation.calculerMontantConsommation(client, consommation);

        assertEquals(montantAttendu, montantCalculé);
    }
    @Test
    public void testCalculerMontantConsommationProCASuperieur1Million() {
        ClientPro client = new ClientPro("EKW98765432", "789123456", "Entreprise ABC", 800000L);
        Energie energie = new Energie(TypeEnergie.GAZ.getLibelle(), new BigDecimal("50"));
        Consommation.LigneConsommation ligne = new Consommation.LigneConsommation(new BigDecimal("50"), energie);
        Consommation consommation = new Consommation();
        consommation.ajouterLigneConsommation(ligne);
        BigDecimal montantAttendu = new BigDecimal("5.650");
        BigDecimal montantCalculé = serviceFacturation.calculerMontantConsommation(client, consommation)
                .setScale(3, RoundingMode.HALF_UP);
        assertEquals(montantAttendu, montantCalculé);
    }
    @Test
    public void testCalculerMontantConsommationProCASInferieur1Million() {
        ClientPro client = new ClientPro("EKW98765432", "789123456", "Entreprise ABC", 500000L);
        Energie energie = new Energie(TypeEnergie.ELEC.getLibelle(), new BigDecimal("50"));
        Consommation.LigneConsommation ligne = new Consommation.LigneConsommation(new BigDecimal("50"), energie);
        Consommation consommation = new Consommation();
        consommation.ajouterLigneConsommation(ligne);

        BigDecimal montantAttendu = new BigDecimal("5.900");
        BigDecimal montantCalculé = serviceFacturation.calculerMontantConsommation(client, consommation);

        assertEquals(montantAttendu, montantCalculé);
    }
    @Test
    public void testCalculerMontantConsommationTypeClientNonReconnu() {
        Client client = new Client() {
        };
        Energie energie = new Energie(TypeEnergie.ELEC.getLibelle(), new BigDecimal("100"));
        Consommation.LigneConsommation ligne = new Consommation.LigneConsommation(new BigDecimal("100"), energie);
        Consommation consommation = new Consommation();
        consommation.ajouterLigneConsommation(ligne);
        BigDecimal montantCalculé = serviceFacturation.calculerMontantConsommation(client, consommation);
        assertEquals(BigDecimal.ZERO, montantCalculé);
    }
    @Test
    public void testCalculerMontantConsommationTypeEnergieNonReconnu() {
        ClientParticulier client = new ClientParticulier("EKW12345678", Civilite.M, "Dupont", "Jean");
        Energie energie = new Energie("Energie inconnue", new BigDecimal("100"));
        Consommation.LigneConsommation ligne = new Consommation.LigneConsommation(new BigDecimal("100"), energie);
        Consommation consommation = new Consommation();
        consommation.ajouterLigneConsommation(ligne);
    }
    @Test
    public void testCalculerMontantConsommationParticulierConsommationNulle() {
        ClientParticulier client = new ClientParticulier("EKW12345678", Civilite.M, "Dupont", "Jean");
        Energie energie = new Energie("Electricité", new BigDecimal("0"));
        Consommation.LigneConsommation ligne = new Consommation.LigneConsommation(new BigDecimal("0"), energie);
        Consommation consommation = new Consommation();
        consommation.ajouterLigneConsommation(ligne);
        BigDecimal montantAttendu = BigDecimal.ZERO;
        BigDecimal montantCalculé = serviceFacturation.calculerMontantConsommation(client, consommation);

        assertEquals(0, montantAttendu.compareTo(montantCalculé));
    }
}