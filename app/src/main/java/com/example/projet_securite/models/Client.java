package com.example.projet_securite.models;

public class Client {

    public String id;
    private String prenom;
    private String nom;
    private String addresse;
    private String telephone;
    private String email;
    //public String photo;


    public Client() {
    }

    public Client(String id,String prenom, String nom, String addresse, String telephone, String email) {

        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.addresse = addresse;
        this.telephone = telephone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
