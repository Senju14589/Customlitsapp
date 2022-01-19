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

        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c};
        String[] name = {"Chanchon","Putting","Panupong"};
        String[] id = {"623410004-6","623410008-8","623410009-6"};
        String[] Time = {"8:45 pm","9:00 am","7:34 pm","6:32 am","5:76 am",
                "5:00 am","7:34 pm","2:32 am","7:76 am"};
        String[] phoneNo = {"062-1319253","064-3469907","061-0953083"};
        String[] country = {"Mahasarakham","Kalasin","Nakhonpanom"};
        String[] universi = {"Khonkean University","Khonkean University","Khonkean University"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],id[i],Time[i],phoneNo[i],country[i],imageId[i]);
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
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("universi",universi[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}