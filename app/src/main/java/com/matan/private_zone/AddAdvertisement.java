package com.matan.private_zone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.matan.coin.R;

public class AddAdvertisement extends AppCompatActivity {

    private static Spinner sourceCoin, destinationCoin, location;
    private static int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_advertisement);

         /*
        Drop down list of Coins
         */

        //get the spinner from the xml.
        Spinner dropdownSourceCoins = findViewById(R.id.sourceCoin);
        //get the spinner from the xml.
        Spinner dropdownDestCoins = findViewById(R.id.destinationCoin);
        //create a list of items for the spinner.
        String[] itemsCoins = new String[]{"Shekel", "Dollar", "three"};
        //create an adapter to describe how the items are displayed
        ArrayAdapter<String> adapterSpinnerCoins = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsCoins);
        //set the spinners adapter to the previously created one.
        dropdownSourceCoins.setAdapter(adapterSpinnerCoins);
        //set the spinners adapter to the previously created one.
        dropdownDestCoins.setAdapter(adapterSpinnerCoins);

        /*
        Drop down list of cities
         */

        //get the spinner from the xml.
        Spinner dropdownCities = findViewById(R.id.location);
        //create a list of items for the spinner.
        String[] itemsCities = new String[]{"Tel Aviv", "Ramat-Gan", "Herzlia"};
        //create an adapter to describe how the items are displayed
        ArrayAdapter<String> adapterSpinnerCities = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsCities);
        //set the spinners adapter to the previously created one.
        dropdownCities.setAdapter(adapterSpinnerCities);

        amount = R.id.amount;





    }
}