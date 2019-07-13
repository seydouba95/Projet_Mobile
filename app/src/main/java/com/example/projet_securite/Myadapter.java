package com.example.projet_securite;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewholder> {

    Context context;
    ArrayList<Gardien> gardien;
    public Myadapter(Context c , ArrayList<Gardien> g)
    {
        this.context=c;
        this.gardien=g;
    }
    @NonNull
    @Override
    public Myadapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewholder(LayoutInflater.from(context).inflate(R.layout.affichage_listgardien,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.MyViewholder myViewholder, int i) {

        myViewholder.txt_prenom.setText(gardien.get(i).getPrenom());
        myViewholder.txt_nom.setText(gardien.get(i).getNom());
        myViewholder.id = gardien.get(i).id;
        myViewholder.adresse = gardien.get(i).getAdresse();
        myViewholder.telephone = gardien.get(i).getTelephone();
        myViewholder.taille=gardien.get(i).getTaille();
        myViewholder.poids=gardien.get(i).getPoids();
        myViewholder.date=gardien.get(i).getDate();


    }

    @Override
    public int getItemCount() {
        return gardien.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView txt_prenom,txt_nom;
        String id,adresse,telephone,taille,poids,date;

        public MyViewholder(@NonNull final View itemView) {
            super(itemView);
            txt_prenom = itemView.findViewById(R.id.prenom);

            txt_nom = itemView.findViewById(R.id.nom);

            txt_prenom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), PageGardienActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("adresse",adresse);
                    intent.putExtra("telephone",telephone);

                    intent.putExtra("taille",taille);
                    intent.putExtra("poids",poids);
                    intent.putExtra("date",date);
                    context.startActivity(intent);
                    Toast.makeText(itemView.getContext(), txt_prenom.getText()+" "+txt_nom.getText(), Toast.LENGTH_SHORT).show();
                }
            });
            txt_nom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), PageGardienActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("adresse",adresse);
                    intent.putExtra("telephone",telephone);
                    intent.putExtra("taille",taille);
                    intent.putExtra("poids",poids);
                    intent.putExtra("date",date);
                    context.startActivity(intent);

                    Toast.makeText(itemView.getContext(), txt_prenom.getText()+" "+txt_nom.getText(), Toast.LENGTH_SHORT).show();
                }
            });



        }

    }
}
