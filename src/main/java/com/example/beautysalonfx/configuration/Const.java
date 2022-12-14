package com.example.beautysalonfx.configuration;

public class Const {
    public static final String USER_TABLE = "users";
   // public static final String USER_ID = "idusers";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ROLE = "role";
    public static final String USER_ENABLED = "enabled";

    public static int USER_ID;

    public static String CHOOSEN_SERVICE;

    public static int RECORD_ID;
    public Const(int id, String name) {
        if (name.equals("user")) {
            this.USER_ID = id;
        } else if (name.equals("record")) {
            this.RECORD_ID = id;
        }
    }

    public Const(String service) {
        this.CHOOSEN_SERVICE = service;
    }

    public Const(int id) {
        this.RECORD_ID = id;
    }
}
