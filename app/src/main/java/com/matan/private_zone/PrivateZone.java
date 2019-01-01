package com.matan.private_zone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.matan.coin.R;
import com.matan.login_and_signup.MainActivity;

import io.paperdb.Paper;

public class PrivateZone extends AppCompatActivity {

    private static Button logoutButton;
    private static Button addAdvertisement;
    private static Button deleteAdvertisement;
    private static Button modifyAdvertisement;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_zone);

        initButtons();





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

        ArrayAdapter<String> adapterlistView = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapterlistView);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                String  itemValue = (String) listView.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });
        // when user log out
        logOut();

        /*
       Button to go to Add advertisement
        */
        final Button privateZoneActivity = (Button)findViewById(R.id.addAdvertisementBtn);
        privateZoneActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent privateZoneIntent = new Intent (PrivateZone.this,AddAdvertisement.class);
                startActivity(privateZoneIntent);
            }
        });
    }
    private void initButtons(){
        logoutButton = (Button) findViewById(R.id.logoutBtn);
        addAdvertisement = (Button) findViewById(R.id.addAdvertisementBtn);
        deleteAdvertisement = (Button) findViewById(R.id.deleteAdvertisementBtn);
        modifyAdvertisement = (Button) findViewById(R.id.modifyAdvertisementBtn);
    }
    private void logOut(){

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                Paper.book().destroy();
                mAuth.signOut();
                Intent intent = new Intent (PrivateZone.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
