package com.example.projet_securite;

public class Agence {

    private String nomAgence;
    private String adresse;
    private String email;
    private String telephone;

    public Agence() {
    }

    public Agence(String nomAgence, String adresse, String email, String telephone) {
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
