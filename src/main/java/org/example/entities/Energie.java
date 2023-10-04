package org.example.entities;

import java.math.BigDecimal;

public class Energie {

    private String type;
    private BigDecimal prixKwh;

    public Energie() {
    }

    public Energie(String type, BigDecimal prixKwh) {
        this.type = type;
        this.prixKwh = prixKwh;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrixKwh() {
        return prixKwh;
    }

    public void setPrixKwh(BigDecimal prixKwh) {
        this.prixKwh = prixKwh;
    }
}