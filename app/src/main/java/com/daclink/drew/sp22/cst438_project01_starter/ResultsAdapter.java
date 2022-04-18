package com.daclink.drew.sp22.cst438_project01_starter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultsAdapter  extends RecyclerView.Adapter<ResultsAdapter.PostViewHolder>{
    List<ResultsPage> resultsList;
    Context context;

    public ResultsAdapter(Context context, List<ResultsPage> results){
        this.context = context;
        resultsList = results;
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.results_page, parent, false);
        return new PostViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        ResultsPage results = resultsList.get(position);
        holder.lyrics.setText(results.getLyrics());
        holder.artist.setText(results.getArtist());
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView lyrics, artist;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            lyrics = itemView.findViewById(R.id.lyrics_id);
            artist = itemView.findViewById(R.id.artist_id);
        }
    }
}
