package com.example.myapplication.ui.home;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Main2Activity;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ExampleItem[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public CardView cardView;

        public MyViewHolder(CardView v) {
            super(v);
            cardView = v;
        }

        @Override
        public void onClick(View v) {
            throw new RuntimeException("dwdwd");
//            cardView.getContext().startActivity(new Intent(cardView.getContext(), Main2Activity.class));
        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerAdapter(ExampleItem[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_example, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ExampleItem exampleItem = mDataset[position];
        TextView tv = holder.cardView.findViewById(R.id.textView1);
        tv.setText(exampleItem.getText1());
        tv = holder.cardView.findViewById(R.id.textView2);
        tv.setText(exampleItem.getText2());
        ImageView iv = holder.cardView.findViewById(R.id.imageView11);
        Picasso picasso = Picasso.get();
        picasso.setLoggingEnabled(true);
        picasso.load(exampleItem.getImageResource()).into(iv);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Main2Activity.class);
                intent.putExtra("recipeId", mDataset[position].getId());
                v.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}