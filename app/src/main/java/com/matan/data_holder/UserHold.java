package com.matan.data_holder;

import com.matan.objects.User;

public class UserHold {
    //static User user=null;
    static String Key_User="";
//    private UserHold(User user,String key){
//        this.user=user;
//        this.Key_User=key;
//    }
    public static void setUser_hold(String key){
        //user=user1;
        Key_User=key;
    }

    public static String getKey_User() {
        return Key_User;
    }
}
