package com.matan.login_and_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.matan.coin.Board;
import com.matan.coin.R;
import com.matan.data_holder.AdvertisementHold;
import com.matan.data_holder.UserHold;
import com.matan.objects.Advertisement;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

import static com.matan.login_and_signup.Utils.Channel;

public class Loading extends AppCompatActivity {

    public static ArrayList<ArrayList<String>> advertisementp = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> a=new ArrayList<String>();
    public static ArrayList<String> advertisements = new ArrayList<String>();
    private FirebaseDatabase mDatabase;
    private DatabaseReference dbRef;
    private Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //prevent duplicates
        if(advertisements.isEmpty())
            read();
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                }
                catch (Exception e){

                }finally {
                    Intent intent=new Intent(Loading.this,Board.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();

    }
    private  void read(){
        Toast.makeText(getApplicationContext(),
                "loging in" , Toast.LENGTH_LONG)
                .show();
        mDatabase = FirebaseDatabase.getInstance();
        dbRef = mDatabase.getReference("/advertisements");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                int i=0;
                for (DataSnapshot datas : snapshot.getChildren()) {
                    advertisements.add(datas.getKey());
                    advertisementp.add(new ArrayList<String>());
                    for(DataSnapshot datas2 : datas.getChildren()){
                        advertisementp.get(i).add(datas2.getValue(String.class));
                    }
                    i++;
                }
                // MainActivity.a.add((User)snapshot.getValue().);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

        });


    }
}
