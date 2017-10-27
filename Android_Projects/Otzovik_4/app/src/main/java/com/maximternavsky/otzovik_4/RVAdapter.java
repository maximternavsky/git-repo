package com.maximternavsky.otzovik_4;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    List<PlaceList> placeLists;
    int fileList;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        private CardView cv;
        private TextView personName;
        private TextView personAge;
        private ImageView personPhoto;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }




    RVAdapter(List<PlaceList> placeLists){
        this.placeLists = placeLists;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder personViewHolder, final int i) {
        personViewHolder.personName.setText(placeLists.get(i).name);
        personViewHolder.personAge.setText(placeLists.get(i).rate);
        personViewHolder.personPhoto.setImageResource(placeLists.get(i).photoId);
        personViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
//
                fileList = personViewHolder.getAdapterPosition();
                Intent intent = new Intent(context, PlaceDescription.class);
                intent.putExtra("FILES_LIST",  placeLists.get(personViewHolder.getAdapterPosition()).photoIdHQ);
                System.out.println( placeLists.get(personViewHolder.getAdapterPosition()).photoId);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return placeLists.size();
    }
}