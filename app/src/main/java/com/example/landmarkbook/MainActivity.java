package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 //static Bitmap selectedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listView);
        //listview'in içerisine metinlerimi nasl ekleyebilirim?
        //-ilk liste oluşturmalıyız.
        //DATA


        final ArrayList<String> landmarNames= new ArrayList<>();
        landmarNames.add("Pisa");
        landmarNames.add("Eiffel");
        landmarNames.add("Colosseo");
        landmarNames.add("London Bridge");

        final ArrayList<String> countryNames= new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colosseo=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colosseo);
        Bitmap londonBridge=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages= new ArrayList<>();
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colosseo);
        landmarkImages.add(londonBridge);

        //diziyi liste içerisinde gösterme(ArrayAdapter)
        //Array Adapterları listview içerisinde bazı contentleri göstermek için kullanıyoruz.
        //simple_list_item_1 listview içersinde sadece metin tutucam demek.

//LİSTVİEW

        ArrayAdapter arrayAdapter= new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarNames);

//böylece bu arrayadapter ile list'i birbirine baglamis olduk.

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               // System.out.println(landmarNames.get(i));
               // System.out.println(countryNames.get(i));

                Intent intent= new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name", landmarNames.get(i));
                intent.putExtra("country", countryNames.get(i));
               // selectedImage=landmarkImages.get(i);

                Singleton singleton= Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(i));
                startActivity(intent);
            }
        });

    }
}