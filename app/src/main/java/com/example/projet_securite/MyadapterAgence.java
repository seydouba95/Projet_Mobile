package com.example.projet_securite;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyadapterAgence  extends RecyclerView.Adapter<MyadapterAgence.MyViewholder> {

    Context context;
    ArrayList<Gardien> gardien;

    public MyadapterAgence(Context c , ArrayList<Gardien> g)
    {
        this.context=c;
        this.gardien=g;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewholder(LayoutInflater.from(context).inflate(R.layout.list_gardien_agence,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder myViewholder, int i) {

        myViewholder.txt_prenom.setText(gardien.get(i).getPrenom());
        myViewholder.txt_nom.setText(gardien.get(i).getNom());
       // myViewholder.agenceid.setText(gardien.get(i).getAgenceId());
       // myViewholder.clientid.setText(gardien.get(i).getClientId());

    }

    @Override
    public int getItemCount() {
        return gardien.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView txt_prenom, txt_nom, agenceid, clientid;


        public MyViewholder(@NonNull final View itemView) {

            super(itemView);
            txt_prenom = itemView.findViewById(R.id.prenom);

            txt_nom = itemView.findViewById(R.id.nom);
            //  agenceid = itemView.findViewById(R.id.agenceid);
            //clientid = itemView.findViewById(R.id.clientid);


        /* itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(itemView.getContext(), PageGardienActivity.class);
                 context.startActivity(intent);
             }
         });


        }*/

        }
    }
}
