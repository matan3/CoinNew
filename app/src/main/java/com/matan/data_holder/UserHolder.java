package com.matan.data_holder;

import com.google.firebase.auth.FirebaseAuth;

public class UserHolder {
    private String userIDEmail;
    private static final UserHolder ourInstance = new UserHolder(FirebaseAuth.getInstance().getCurrentUser().getEmail());

    public static UserHolder getInstance() {
        return ourInstance;
    }

    private UserHolder(String userIDEmail) {
        this.userIDEmail=userIDEmail;
    }
}
