package com.example.projet_securite;

public class Client {

    public String prenom;
    public String nom;
    public String addresse;
    public String telephone;
    public String email;
    //public String photo;


    public Client() {
    }

    public Client(String prenom, String nom, String addresse, String telephone, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.addresse = addresse;
        this.telephone = telephone;
        this.email = email;
    }

}
