package com.example.projet_securite;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Utilitaire  {

    static public String agenceConnecte;

    // Par défaut le profile est "client".
    // Après connexion d'une agence, le
    // profile doit changer à "agence".
    // Cette variable est accessible dans tous
    // les autres classe avec Utilitaire.profile.
    // Après déconnexion d'une agence, le profile
    // doit redevenir "client".
    static public  String profile = "client";

    static public boolean unAgenceEstConnecte() {
        return  FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    static public String getAgenceConnecteId() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
