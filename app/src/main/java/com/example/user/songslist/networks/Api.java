package com.example.user.songslist.networks;

import com.example.user.songslist.data.remote.Songs;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;


public interface Api {

    @GET("bins/rov51")
    Flowable<List<Songs>> getSongs();
}
