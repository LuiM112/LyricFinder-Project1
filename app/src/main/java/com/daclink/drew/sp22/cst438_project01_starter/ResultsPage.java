package com.daclink.drew.sp22.cst438_project01_starter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.daclink.drew.sp22.cst438_project01_starter.databinding.FragmentLoginBinding;
import com.daclink.drew.sp22.cst438_project01_starter.databinding.ResultsPageBinding;

import java.util.zip.Inflater;

public class ResultsPage extends Fragment {
    private ResultsPageBinding binding;
    //Model Class
    private String lyrics, lyrics_id;
    public String getLyrics() {
        return lyrics;
    }

    public String getArtist() {
        return lyrics_id;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ){
        binding = ResultsPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }




}