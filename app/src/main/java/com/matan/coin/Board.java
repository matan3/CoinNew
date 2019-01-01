package com.matan.coin;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.matan.Chat.MainChat;
import com.matan.login_and_signup.Loading;
import com.matan.login_and_signup.MainActivity;
import com.matan.objects.Advertisement;
import com.matan.objects.User;
import com.matan.private_zone.PrivateZone;

import java.util.ArrayList;

import static com.matan.login_and_signup.Utils.Channel;

public class Board extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference dbRef;

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        //read();

        /*
        Drop down list of cities
         */

        //get the spinner from the xml.
        Spinner dropdownCities = findViewById(R.id.spinner1);
        //create a list of items for the spinner.
        String[] itemsCities = new String[]{"1", "2", "three"};
        //create an adapter to describe how the items are displayed
        ArrayAdapter<String> adapterSpinnerCities = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsCities);
        //set the spinners adapter to the previously created one.
        dropdownCities.setAdapter(adapterSpinnerCities);

        /*
        Drop down list of Coins
         */

        //get the spinner from the xml.
        Spinner dropdownCoins = findViewById(R.id.spinner2);
        //create a list of items for the spinner.
        String[] itemsCoins = new String[]{"Shekel", "Dollar", "three"};
        //create an adapter to describe how the items are displayed
        ArrayAdapter<String> adapterSpinnerCoins = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsCoins);
        //set the spinners adapter to the previously created one.
        dropdownCoins.setAdapter(adapterSpinnerCoins);

        /*
        list of all the advertisement
         */

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View",
                "Android Example List View",
                "Android Example List View",
                "Android Example List View",
                "Android Example List View",
                "Android Example List View",
                "Android Example List View",
                "Android Example List View",
                "Android Example List View"
        };


  /*      String[] arr=new String[MainActivity.a.size()];
        for(int i=0;i<arr.length;i++)
            arr[i]=MainActivity.a.get(i).toString();
*/
//        Toast.makeText(getApplicationContext(),
//                ""+MainActivity.a.size() , Toast.LENGTH_LONG)
//                .show();
        ArrayAdapter<String> adapterlistView = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Loading.advertisements);

        listView.setAdapter(adapterlistView);


        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;
                //MainChat.send=MainActivity.a.get(itemPosition);
                AdvertisementProperties.advertisementId = Loading.advertisements.get(itemPosition);
                AdvertisementProperties.advertisementPosition = itemPosition;
                Intent intent = new Intent (Board.this, AdvertisementProperties.class);
                startActivity(intent);
                // ListView Clicked item value
                String  itemValue = (String) listView.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });


         /*
        Button to go to PrivateZone
         */
        final Button privateZoneActivity = (Button)findViewById(R.id.privateZoneBtn);
        privateZoneActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent privateZoneIntent = new Intent (Board.this,PrivateZone.class);
                startActivity(privateZoneIntent);
            }
        });
    }
    // when back is pressed, go to home screen
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
     /*finish();
     System.exit(0);*/
        return;
    }
    private  void read(){
        Toast.makeText(getApplicationContext(),
               "read" , Toast.LENGTH_LONG)
                .show();
        createChannel();
        addNotification(Channel);
        mDatabase = FirebaseDatabase.getInstance();
        dbRef = mDatabase.getReference("/user");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    MainActivity.a.add(datas.toString());


                }
                // MainActivity.a.add((User)snapshot.getValue().);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

        });
    }
    private void createChannel()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager mNotificationManager = getSystemService(NotificationManager.class);
            String id = Channel;
            CharSequence name = "Chat";
            String description = "message from user a";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(id, name, importance);
            mChannel.setDescription(description);

            mNotificationManager.createNotificationChannel(mChannel);
        }
    }
    private void addNotification(String channel)
    {
        Intent landingIntent = new Intent(this, NotificationManager.class);
        PendingIntent pendingLandingIntent = PendingIntent.getActivity(this,0,landingIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder notificationBuilder;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            notificationBuilder = new Notification.Builder(this,channel);
        }
        else
        {
            notificationBuilder = new Notification.Builder(this);
        }

        Notification notification = notificationBuilder
                .setContentTitle("notification type"+channel)
                .setSmallIcon(R.drawable.email)
                .setContentText("You have a new message in channel"+channel)
                .setContentIntent(pendingLandingIntent)
                .setAutoCancel(true).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int)System.currentTimeMillis(),notification);
    }
}
