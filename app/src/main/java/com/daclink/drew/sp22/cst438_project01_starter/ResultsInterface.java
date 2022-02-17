package com.daclink.drew.sp22.cst438_project01_starter;

import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ResultsInterface {
    @GET("apilink")
    Call<List<ResultsPage>> getResults();

}
