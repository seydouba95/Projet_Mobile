package com.example.projet_securite;

public class Demande {

    private String gardienid;
    private String clientid;

    public Demande(String gardienid,String clientid) {
        this.gardienid = gardienid;

        this.clientid = clientid;


    }


    public String getGardienid() {
        return gardienid;
    }

    public void setGardienid(String gardienid) {
        this.gardienid = gardienid;
    }



    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }
}
