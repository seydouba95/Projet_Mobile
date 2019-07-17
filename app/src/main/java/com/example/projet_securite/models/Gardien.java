package com.example.projet_securite.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;

@IgnoreExtraProperties
public class Gardien {

  public String id;
    private String nom;
    private String prenom;
    private  String adresse;
    private String telephone;
    private String taille;
    private String poids;
    private String date;

    private String clientId;
    private String agenceId;

   // public Date date;

    public Gardien() {
    }

    public Gardien(String id, String prenom, String nom, String date, String address,String taille, String poids, String phone,String clientId, String agenceId) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.adresse = address;
        this.telephone = phone;

        this.taille = taille;
        this.poids = poids;
        this.clientId = clientId;
        this.agenceId = agenceId;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(String agenceId) {
        this.agenceId = agenceId;
    }
}
