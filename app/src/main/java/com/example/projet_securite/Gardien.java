package com.example.projet_securite;

import java.util.Date;

public class Gardien {

    public String nom;
    public String prenom;
    public String addresse;
    public String telephone;
    public String age;
    public String taille;
    public String poids;
    public Date date;




    public Gardien() {
    }

    public Gardien(String nom, String prenom, String addresse, String telephone,String age, String taille, String poids, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
        this.telephone = telephone;
        this.age = age;
        this.taille = taille;
        this.poids = poids;
        this.date = date;
    }
}
