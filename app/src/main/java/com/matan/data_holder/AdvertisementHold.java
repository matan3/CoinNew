package com.matan.data_holder;

public class AdvertisementHold {
    private static final AdvertisementHold ourInstance = new AdvertisementHold();

    public static AdvertisementHold getInstance() {
        return ourInstance;
    }

    private AdvertisementHold() {
        String key_ad = "";
    }
}
