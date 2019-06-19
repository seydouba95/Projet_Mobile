package com.example.projet_securite;

import java.util.Date;

public class Gardien {

  public String id;
    public String nom;
    public String prenom;
    public String addresse;
    public String telephone;
    public String age;
    public String taille;
    public String poids;
    public String date;

   // public Date date;




    public Gardien(String id, String prenom, String nom, String date, String address, String age, String taille, String poids, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.addresse = address;
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

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
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
