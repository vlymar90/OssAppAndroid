package com.example.ossapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ossapp.R;

/*
класс список бойцов
 */
public class FightersList extends RecyclerView.Adapter<FightersList.FighterViewHolder> {

    private static int numberOfHolders;
    private int numberOfFighters;


    public FightersList(int numberFighters) {
        numberOfFighters = numberFighters;
        numberOfHolders = 0;
    }

    /*
    создание объекта боец
     */
    @Override
    public FighterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.fighter;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);

        FighterViewHolder fighterHolder = new FighterViewHolder(view);
        fighterHolder.viewHolderNumber.setText("Fighter number " + numberOfHolders);

        numberOfHolders++;

        return fighterHolder;
    }

    /*
    связывает объект боец с содержимым
     */
    @Override
    public void onBindViewHolder(FighterViewHolder holder, int position) {
        holder.bind(position);
    }

    /*
    возвращает количество бойцов
     */
    @Override
    public int getItemCount() {
        return numberOfFighters;
    }


    /*
    класс списка одного бойца
     */
    class FighterViewHolder extends RecyclerView.ViewHolder {

        TextView fighterNumber;
        TextView viewHolderNumber;

        public FighterViewHolder(View itemView) {
            super(itemView);

            fighterNumber = itemView.findViewById(R.id.number_fighter);
            viewHolderNumber = itemView.findViewById(R.id.view_holder_number);

        }

        void bind(int listIndex) {
            fighterNumber.setText(String.valueOf(listIndex));
        }
    }
}
