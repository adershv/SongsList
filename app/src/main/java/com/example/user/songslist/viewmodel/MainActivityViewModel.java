package com.example.user.songslist.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.user.songslist.data.remote.Songs;
import com.example.user.songslist.repository.SongsRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    LiveData<List<Songs>> songsLiveData;

    SongsRepository songsRepository;


    public MainActivityViewModel() {
        songsRepository = SongsRepository.getRepo();
    }

    public LiveData<List<Songs>> getSongsLiveData(){
        return songsRepository.getSongs();
    }

}
