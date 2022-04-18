package com.daclink.drew.sp22.cst438_project01_starter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResultsInterface {
    @GET("q_lyrics")
    Call<List<ResultsPage>> getResults();

}
