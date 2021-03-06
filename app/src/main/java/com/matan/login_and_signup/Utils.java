package com.matan.login_and_signup;

import com.matan.objects.User;

public class Utils {
    //Email Validation pattern
    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

    //Fragments Tags
    public static final String Login = "Login";
    public static final String SignUp = "SignUp";
    public static final String ForgotPassword = "ForgotPassword";
    public static final String PrivateZone = "PrivateZone";
    public static final String Channel = "Channel";

    //Stay Online
    public static User currectOnLineUser;
    public static final String UserEmailKey = "UserEmail";
    public static final String UserPasswordKey = "UserPassword";
}
