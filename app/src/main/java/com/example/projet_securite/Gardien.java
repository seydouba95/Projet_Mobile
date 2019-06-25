package com.example.projet_securite;

import java.util.Date;

public class Gardien {

  public String id;
    public String nom;
    public String prenom;
    public String adresse;
    public String telephone;
    public String age;
    public String taille;
    public String poids;
    public String date;

   // public Date date;


    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Gardien() {
    }

    public Gardien(String id, String prenom, String nom, String date, String address, String age, String taille, String poids, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.adresse = address;
        this.telephone = phone;
        this.age = age;
        this.taille = taille;
        this.poids = poids;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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





}
