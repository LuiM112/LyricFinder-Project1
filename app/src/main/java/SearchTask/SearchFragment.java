package SearchTask;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.daclink.drew.sp22.cst438_project01_starter.R;
import com.daclink.drew.sp22.cst438_project01_starter.databinding.FragmentSearchBinding;

import java.util.ArrayList;

import LyricFinderTask.ApiKey;
import LyricFinderTask.lyricFinder;
import Retrofit.retrofitClient;
import models.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    private EditText searched;
    private Button mSearchButton;
    private String lyrics;
    private static final String TAG = "SearchFragment";
    private static final String format = "matcher.lyrics.get?format=json&callback=callback&";
    private static final String artist_search_parameter = "&q_artist=";
    private static final String track_search_parameter = "&q_track=";

    private ApiKey key;

    private EditText artist_text;
    private EditText song_text;
    private Button search;
    private String artistString;
    private String songString;
    private String apiKey;

    private FragmentSearchBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ){

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        artist_text = view.findViewById(R.id.artist_name);
        song_text = view.findViewById(R.id.song_name);

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                artistString = artist_text.getText().toString();
                Log.e(TAG, "onCreate: String" + artistString);
                songString = song_text.getText().toString();
                Log.e(TAG, "onCreate: String" + songString);
                apiKey = key.getKey();
                lyricFinder lf = retrofitClient.getRetrofitInstance().create(lyricFinder.class);
                Call<Data> call = lf.getAllData(artistString,songString,apiKey);

                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Log.e(TAG, "onResponse: code :" + response.code() );

                        ArrayList<Data.data> info = response.body().getData();

                        for (Data.data info1 : info){
                            Log.e(TAG, "onResponse: body" + info1.getBody() );
                        }

                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {

                    }
                });

                NavHostFragment.findNavController(SearchFragment.this)
                        .navigate(R.id.action_SearchFragment_to_ResultPage);
            }
        });
    }

}