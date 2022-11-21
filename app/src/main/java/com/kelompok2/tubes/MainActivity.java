package com.kelompok2.tubes;

import static android.os.Looper.prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private TypedArray datapoto;
    private Hubung hubung;
    private ArrayList<Gambar> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hubung = new Hubung(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(hubung);

        prepare();
        additem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                if (position == 0) {
                    //sejarah
                    startActivity(new Intent(MainActivity.this, Indonesia.class));
                } else if (position == 1) {
                    //maakanan
                    startActivity(new Intent(MainActivity.this, Malaysia.class));
                } else if (position == 2) {
                    //wisata
                    startActivity(new Intent(MainActivity.this, Filipina.class));

                } else if (position == 3) {
                    //maakanan
                    startActivity(new Intent(MainActivity.this, Kamboja.class));
                } else if (position == 4) {
                    //wisata
                    startActivity(new Intent(MainActivity.this, Myanmar.class));
                } else if (position == 5) {
                    //maakanan
                    startActivity(new Intent(MainActivity.this, Laos.class));
                } else if (position == 6) {
                    //wisata
                    startActivity(new Intent(MainActivity.this, Thailand.class));
                } else if (position == 7) {
                    //maakanan
                    startActivity(new Intent(MainActivity.this, Singapura.class));
                } else if (position == 8) {
                    //wisata
                    startActivity(new Intent(MainActivity.this, Vietnam.class));
                } else if (position == 9) {
                    //wisata
                    startActivity(new Intent(MainActivity.this, BruneiDarussalam.class));
                }
            }
        });
    }

    private void additem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Gambar hero = new Gambar();
            hero.setPhoto(datapoto.getResourceId(i, -1));
            hero.setNama(dataName[i]);
            heroes.add(hero);
        }
        hubung.setHeroes(heroes);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        datapoto = getResources().obtainTypedArray(R.array.datapoto);
    }
}