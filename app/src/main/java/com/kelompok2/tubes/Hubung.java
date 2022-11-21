package com.kelompok2.tubes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Hubung extends BaseAdapter {
    private Context context;
    private ArrayList<Gambar> heroes;
    void setHeroes (ArrayList<Gambar> heroes) {
        this.heroes = heroes;
    }
    Hubung(Context context){
        this.context = context;
        heroes = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.gambar, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Gambar hero = (Gambar) getItem(i);
        viewHolder.bind(hero);
        return view;
    }
    private class ViewHolder {
        private ImageView imgPhoto;
        private TextView txtName;

        ViewHolder (View view) {
            imgPhoto = view.findViewById(R.id.img_photo);
            txtName = view.findViewById(R.id.txt_name);
        }

        void bind(Gambar hero) {
            txtName.setText(hero.getNama());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}