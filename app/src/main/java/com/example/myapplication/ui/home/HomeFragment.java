package com.example.myapplication.ui.home;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        AsyncTask<Void, Integer, ExampleItem[]> execute = new AsyncRequest().execute();
        ExampleItem[] exampleItems = new ExampleItem[0];
        try {
            exampleItems = execute.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RecyclerAdapter mAdapter = new RecyclerAdapter(exampleItems);
        recyclerView.setAdapter(mAdapter);
        return root;
    }


    static class AsyncRequest extends AsyncTask<Void, Integer, ExampleItem[]> {

        @Override
        protected ExampleItem[] doInBackground(Void... voids) {
            return getArrayOfItems();
        }
    }


    public static ExampleItem[] getArrayOfItems() {
//        String [] ingr = {"лук-шалот – 100 г","чеснок – 3 зубчика","белые грибы свежие – 400 г","оливковое масло - 60 мл","рис круглозерный - 400 г","бульон овощной – 300-400 мл","масло сливочное – 40 г (не для постного варианта)","пармезан тертый – 70 г (не для постного варианта)","петрушка для подачи","оливковое масло «экстра вирджин» для подачи","соль, свежемолотый чёрный перец", "лук-шалот – 100 г","чеснок – 3 зубчика","белые грибы свежие – 400 г","оливковое масло - 60 мл","рис круглозерный - 400 г","бульон овощной – 300-400 мл","масло сливочное – 40 г (не для постного варианта)","пармезан тертый – 70 г (не для постного варианта)","петрушка для подачи","оливковое масло «экстра вирджин» для подачи","соль, свежемолотый чёрный перец"};
//        String description = "Мелко порубить лук шалот и чеснок. Белые грибы почистить, тонко нарезать, обжарить в оливковом масле на сковороде с двумя зубчиками рубленого чеснока и луком. Отложить в сторону несколько кусочков белых грибов для украшения блюда";
//        ExampleItem.Step[] steps = {new ExampleItem.Step(description, "https://www.gastronom.ru/binfiles/images/20160701/b5a84070.jpg"),
//                new ExampleItem.Step(description, "https://www.gastronom.ru/binfiles/images/20160701/b5a84070.jpg"),
//                new ExampleItem.Step(description, "https://www.gastronom.ru/binfiles/images/20160701/b5a84070.jpg"),
//                new ExampleItem.Step(description, "https://www.gastronom.ru/binfiles/images/20160701/b5a84070.jpg"),};
//        ExampleItem [] a = {
//                new ExampleItem("https://www.gastronom.ru/binfiles/images/20190619/ba49be1a.jpg",
//                        "Паэлья на углях с колбасками и тремя видами мяса",
//                        "питательно, мясное, испанская кухня", "1", ingr, steps),
//                new ExampleItem("https://www.gastronom.ru/binfiles/images/20160223/b18f9c36.jpg",
//                        "Ризотто с белыми грибами", "питательно, вегетарианское", "2",
//                        ingr, steps)
//        };
//        return a;

        RestClient restClient = new RestClient();
        return restClient.getRecipes(20);
    }

    public static ExampleItem getRecipe(String id) {
        AsyncTask<Void, Integer, ExampleItem[]> execute = new AsyncRequest().execute();
        ExampleItem[] exampleItems = new ExampleItem[0];
        try {
            exampleItems = execute.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (ExampleItem el : exampleItems) {
            if (el.getId().equals(id)) {
                return el;
            }
        }
        throw new RuntimeException("Not found");
    }
}
