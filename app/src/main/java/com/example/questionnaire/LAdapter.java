package com.example.questionnaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LAdapter extends RecyclerView.Adapter<LAdapter.MyViewHolder>
{

    Context context;

    ArrayList<Location> list;

    public LAdapter(Context context, ArrayList<Location> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,true);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Location location = list.get(position);
        holder.date.setText(location.getDate());
        holder.time.setText(location.getTime());
        holder.venue.setText(location.getVenue());
        holder.description.setText(location.getDescription());
        holder.notice.setText(location.getNotice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date,time,venue,description,notice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.textViewDate);
            time=itemView.findViewById(R.id.textViewTime);
            venue=itemView.findViewById(R.id.textViewVenue);
            description=itemView.findViewById(R.id.textViewDescription);
            notice=itemView.findViewById(R.id.textViewSpecialNotice);
        }
    }
}
