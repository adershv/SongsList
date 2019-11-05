package com.example.user.songslist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.user.songslist.R;
import com.example.user.songslist.data.remote.Songs;
import com.example.user.songslist.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    LiveData<List<Songs>> songs;

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getSongsLiveData().observe(this, new Observer<List<Songs>>() {
            @Override
            public void onChanged(List<Songs> songs) {
                String album = songs.get(0).getAlbum();
                Toast.makeText(MainActivity.this,album,Toast.LENGTH_LONG).show();
            }
        });

    }




}
