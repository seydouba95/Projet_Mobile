package com.example.projet_securite;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewholder> {

    Context context;
    ArrayList<Gardien> listGardiens;

    public Myadapter(Context c, ArrayList<Gardien> g) {
        this.context = c;
        this.listGardiens = g;
    }

    @NonNull
    @Override
    public Myadapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewholder(LayoutInflater.from(context).inflate(R.layout.affichage_listgardien, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.MyViewholder myViewholder, int i) {
        Gardien gardien = listGardiens.get(i);
        myViewholder.txt_prenom.setText(gardien.getPrenom());
        myViewholder.txt_nom.setText(gardien.getNom());
        myViewholder.id = gardien.id;
        myViewholder.adresse = gardien.getAdresse();
        myViewholder.telephone = gardien.getTelephone();
        myViewholder.taille = gardien.getTaille();
        myViewholder.poids = gardien.getPoids();
        myViewholder.date = gardien.getDate();
        myViewholder.clientId = gardien.getClientId();
        myViewholder.agenceId = gardien.getAgenceId();
    }

    @Override
    public int getItemCount() {
        return listGardiens.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView txt_prenom, txt_nom;
        String id, adresse, telephone, taille, poids, date, clientId, agenceId;

        public MyViewholder(@NonNull final View itemView) {
            super(itemView);
            txt_prenom = itemView.findViewById(R.id.prenom);

            txt_nom = itemView.findViewById(R.id.nom);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), PageGardienActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("adresse", adresse);
                    intent.putExtra("telephone", telephone);
                    intent.putExtra("taille", taille);
                    intent.putExtra("poids", poids);
                    intent.putExtra("date", date);
                    intent.putExtra("clientId", clientId);
                    intent.putExtra("agenceId", agenceId);

                    context.startActivity(intent);
                }
            });
        }

    }
}
