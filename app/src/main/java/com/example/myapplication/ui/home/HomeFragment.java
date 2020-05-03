package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        RecyclerAdapter  mAdapter = new RecyclerAdapter(getArrayOfItems());
        recyclerView.setAdapter(mAdapter);
        return root;
    }


    private ExampleItem [] getArrayOfItems(){
        ExampleItem [] a = {
                new ExampleItem("https://sun9-23.userapi.com/c850620/v850620759/4913e/sfE0Fl6HkFY.jpg", "t1", "t2"),
                new ExampleItem("https://sun9-65.userapi.com/c844521/v844521549/1fa988/EVdmwdYJpiQ.jpg", "t3", "t4"),
        };
        return a;
    }
}
