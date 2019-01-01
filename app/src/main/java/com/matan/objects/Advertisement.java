package com.matan.objects;

import com.matan.login_and_signup.MainActivity;

public class Advertisement {

    private final String Advertisement_id ;
    private  String Source_Coin ,Destination_Coin,Location ,email , Amount;

    /*
   Constructors
    */
    public Advertisement(String email, String source_Coin, String destination_Coin, String location, String amount) {
        Advertisement_id=""+MainActivity.Advertisement_key++;
        this.email = email;
        Source_Coin = source_Coin;
        Destination_Coin = destination_Coin;
        Location = location;
        Amount = amount;
    }

    public Advertisement() {
        Advertisement_id=""+MainActivity.Advertisement_key++;

    }

    /*
    Getters / Setters
     */
    public String getEmail() {
        return email;
    }

    public String getSource_Coin() {
        return Source_Coin;
    }
    public void setSource_Coin(String source_Coin) {
        Source_Coin = source_Coin;
    }
    public String getDestination_Coin() {
        return Destination_Coin;
    }
    public void setDestination_Coin(String destination_Coin) {
        Destination_Coin = destination_Coin;
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public String getAmount() {
        return Amount;
    }
    public void setAmount(String amount) {
        Amount = amount;
    }
    public String getAdvertisement_id() {
        return Advertisement_id;
    }
}
