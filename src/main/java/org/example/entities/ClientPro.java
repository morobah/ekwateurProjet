package org.example.entities;

public class ClientPro extends Client {

    private String siret;
    private String raisonSociale;
    private Long ca;

    public ClientPro() {
    }

    public ClientPro(String referenceClient, String siret, String raisonSociale, Long ca) {
        super(referenceClient);
        this.siret = siret;
        this.raisonSociale = raisonSociale;
        this.ca = ca;
    }

    public String getSiret() {

        return siret;
    }

    public void setSiret(String siret) {

        this.siret = siret;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Long getCa() {

        return ca;
    }

    public void setCa(Long ca) {

        this.ca = ca;
    }

    private static String validateReferenceClient(String referenceClient) {
        if (referenceClient.matches("EKW\\d{8}")) {
            return referenceClient;
        } else {
            throw new IllegalArgumentException("La référence client doit être au format EKW suivi de 8 caractères numériques.");
        }
    }
}