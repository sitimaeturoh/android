package com.sitimaeturoh.kuis2222.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Server on 13/09/2017.
 */
public class RetroServer {

    //url tersimpanya file-file web service
    private static final String base_url =
            "http://192.168.43.26/kuis/";
    private static Retrofit retrofit;
    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

