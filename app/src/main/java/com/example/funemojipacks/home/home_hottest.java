package com.example.funemojipacks.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.funemojipacks.R;

public class home_hottest extends Fragment {
    public home_hottest()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
                             savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_home_hottest,container,false);
    }
}