package com.example.projet_securite.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Agence {

    public String id;
    public String nom;
    public String addresse;
    public String email;
    public String telephone;

    public Agence() {
    }

    public Agence(String nomAgence, String adresse, String email, String telephone) {
        this.nom = nomAgence;
        this.addresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
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
