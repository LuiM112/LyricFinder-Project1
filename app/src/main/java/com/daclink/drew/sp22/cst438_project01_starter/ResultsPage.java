package com.daclink.drew.sp22.cst438_project01_starter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daclink.drew.sp22.cst438_project01_starter.databinding.FragmentFirstBinding;
import com.daclink.drew.sp22.cst438_project01_starter.databinding.FragmentSecondBinding;
import com.daclink.drew.sp22.cst438_project01_starter.databinding.ResultsPageBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultsPage extends Fragment {
    private ResultsPageBinding binding;
    private RecyclerView recyclerView;
    //Model Class
    private String q_track, q_artist, q_lyrics;

    public String getLyrics() {
        return q_lyrics;
    }

    public String getArtist() {
        return q_artist;
    }

    public String getTrack() {
        return q_track;
    }



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ){
        binding = ResultsPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));

        binding.buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ResultsPage.this)
                        .navigate(R.id.action_ResultFragment_to_FirstFragment);
            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developer.musixmatch.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ResultsInterface resultsInterface = retrofit.create(ResultsInterface.class);

        Call<List<ResultsPage>> call = resultsInterface.getResults();

        call.enqueue(new Callback<List<ResultsPage>>() {
            @Override
            public void onResponse(Call<List<ResultsPage>> call, Response<List<ResultsPage>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getActivity().getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<ResultsPage> resultsList = response.body();
                ResultsAdapter resultsAdapter = new ResultsAdapter(getActivity().getApplicationContext(), resultsList);
                recyclerView.setAdapter(resultsAdapter);

            }

            @Override
            public void onFailure(Call<List<ResultsPage>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
