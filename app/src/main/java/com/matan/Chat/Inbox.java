package com.matan.Chat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.matan.coin.R;
import com.matan.login_and_signup.MainActivity;

public class Inbox extends Activity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference dbRef;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
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


        String[] arr=new String[MainActivity.b.size()];
        for(int i=0;i<arr.length;i++)
            arr[i]=MainActivity.b.get(i).toString();
        Toast.makeText(getApplicationContext(),
                ""+MainActivity.b.size() , Toast.LENGTH_LONG)
                .show();
        ArrayAdapter<String> adapterlistView = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, arr);

        // Assign adapter to ListView
        listView.setAdapter(adapterlistView);

        // ListView Item Click Listener
/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;
                MainChat.send=MainActivity.a.get(itemPosition);
                Intent intent = new Intent (Board.this, MainChat.class);
                startActivity(intent);
                finish();
                // ListView Clicked item value
                String  itemValue = (String) listView.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });*/


    }
}
