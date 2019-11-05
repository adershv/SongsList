package com.example.user.songslist.repository;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.user.songslist.data.remote.Songs;
import com.example.user.songslist.networks.Api;
import com.example.user.songslist.networks.RetrofitClient;

import java.util.List;
import io.reactivex.schedulers.Schedulers;


public class SongsRepository {

    private static SongsRepository songsRepository= null;

    MutableLiveData<List<Songs>> songsLiveData;
    MediatorLiveData<List<Songs>> songsMediatorLiveData  = new MediatorLiveData();

    private SongsRepository(){


    }

    public static synchronized SongsRepository getRepo(){
        if(songsRepository==null){
            songsRepository = new SongsRepository();
        }

        return songsRepository;
    }


    public LiveData<List<Songs>> getSongs(){
        Api api = RetrofitClient.getClient().create(Api.class);

            final LiveData<List<Songs>> source = LiveDataReactiveStreams.fromPublisher(
                    api.getSongs().subscribeOn(Schedulers.io()));

        songsMediatorLiveData.addSource(source, new Observer<List<Songs>>() {
            @Override
            public void onChanged(List<Songs> songs) {
               // songsMediatorLiveData.setValue(songs);
               // songsMediatorLiveData.removeSource(source);
            }
        });

        return songsMediatorLiveData;
    }
}
