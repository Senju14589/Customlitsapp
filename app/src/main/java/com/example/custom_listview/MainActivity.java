package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.custom_listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.b,R.drawable.a,R.drawable.c};
        String[] name = {"Puttipong","Chanchon","Panupong"};
        String[] id = {"623410008-8","623410004-6","623410009-6"};
        String[] number = {"01","02","03"};
        String[] phone = {"064-3469907","062-1319253","061-0953083"};
        String[] country = {"Kalasin","Mahasarakham","Nakhonpanom"};
        String[] universi = {"KKU NKC","KKU NKC","KKU NKC"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],id[i],number[i],phone[i],country[i],imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phone[position]);
                i.putExtra("country",country[position]);
                i.putExtra("universi",universi[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}