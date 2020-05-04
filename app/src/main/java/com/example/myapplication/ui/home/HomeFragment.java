package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

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


    public static ExampleItem [] getArrayOfItems(){
        String [] ingr = {"лук-шалот – 100 г","чеснок – 3 зубчика","белые грибы свежие – 400 г","оливковое масло - 60 мл","рис круглозерный - 400 г","бульон овощной – 300-400 мл","масло сливочное – 40 г (не для постного варианта)","пармезан тертый – 70 г (не для постного варианта)","петрушка для подачи","оливковое масло «экстра вирджин» для подачи","соль, свежемолотый чёрный перец"};
        ExampleItem [] a = {
                new ExampleItem("https://www.gastronom.ru/binfiles/images/20190619/ba49be1a.jpg",
                        "Паэлья на углях с колбасками и тремя видами мяса",
                        "питательно, мясное, испанская кухня", "1", ingr),
                new ExampleItem("https://www.gastronom.ru/binfiles/images/20160223/b18f9c36.jpg",
                        "Ризотто с белыми грибами", "питательно, вегетарианское", "2",
                        ingr)
        };
        return a;
    }

    public static ExampleItem  getRecipe(String id){
        ExampleItem [] a = getArrayOfItems();
        for(ExampleItem el : getArrayOfItems()){
            if(el.getId().equals(id)){
                return el;
            }
        }
        throw new RuntimeException("Not found");
    }
}
