package com.matan.coin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.matan.Chat.MainChat;
import com.matan.login_and_signup.Loading;

import java.util.ArrayList;

public class AdvertisementProperties extends AppCompatActivity {

    public static int advertisementPosition;
    public static String advertisementId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement_properties);

        ListView properties = (ListView) findViewById(R.id.adproperties);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,
                Loading.advertisementp.get(advertisementPosition));

        //Attach inner list to list view
        properties.setAdapter(adapter);

        //Button to MainChat
        final Button chatActivity = (Button) findViewById(R.id.chat);
        chatActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //email is the 3rd property of advertisement in firebase
                String email = Loading.advertisementp.get(advertisementPosition).get(2);
                MainChat.send = email;
                Intent intent = new Intent(AdvertisementProperties.this,MainChat.class);
                startActivity(intent);
            }
        });

    }
}
