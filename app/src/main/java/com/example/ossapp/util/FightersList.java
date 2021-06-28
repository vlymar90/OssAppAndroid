package com.example.ossapp.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ossapp.PartnerActivity;
import com.example.ossapp.R;
import com.example.ossapp.dto.UserDto;
import com.example.ossapp.dto.UserResponseDto;
import com.example.ossapp.registration.CountryActivity;

import java.util.List;

/*
класс список бойцов
 */
public class FightersList extends RecyclerView.Adapter<FightersList.FighterViewHolder> {

    private static int numberOfHolders;
    private int numberOfFighters;
    private UserResponseDto userResponseDto;
    List<UserResponseDto> fighters;

    /*
    принимает список запрошенных бойцов
     */
    public FightersList(List<UserResponseDto> list) {
        fighters = list;
        numberOfFighters = list.size();
        numberOfHolders = 0;
    }

    /*
    создание карточки бойца
     */
    @Override
    public FighterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.fighter;


        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);

        FighterViewHolder fighterHolder = new FighterViewHolder(view);

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
    содержимое карточки одного бойца
     */
    class FighterViewHolder extends RecyclerView.ViewHolder {
        TextView fighterName;
        TextView fighterAge;
        TextView fighterCity;
        TextView fighterWeight;
        TextView fighterStyle;
        TextView viewHolderNumber;

        public FighterViewHolder(View itemView) {
            super(itemView);
            fighterName = itemView.findViewById(R.id.name_fighter);
            fighterAge = itemView.findViewById(R.id.age_fighter);
            fighterCity = itemView.findViewById(R.id.city_fighter);
            fighterWeight = itemView.findViewById(R.id.weight_fighter);
            fighterStyle = itemView.findViewById(R.id.style_fighter);
            viewHolderNumber = itemView.findViewById(R.id.view_holder_number);
        }

        /*
        связь содержимого с карточкой бойца
         */
        void bind(int listIndex) {
            userResponseDto = fighters.get(listIndex);
            fighterName.setText(userResponseDto.getName() + ",");
            fighterWeight.setText(String.valueOf(userResponseDto.getUserWeight()));
            fighterAge.setText(String.valueOf(userResponseDto.getUserAge()));
            fighterCity.setText("Город " + userResponseDto.getCity());
            fighterStyle.setText(userResponseDto.getStyle() + " " + userResponseDto.getLevel()); //пока в стринге
        }
    }
}
