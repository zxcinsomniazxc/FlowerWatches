package com.example.flowerwatches;

import android.content.Context;

import java.util.List;

public class UsersAdapter {

    private final static String USERS_URL = "http://cinema.areas.su/up/images/";
    private List<Users> mUsers;
    private Context mContext;

    UsersAdapter(List<Users> users) {
        this.mUsers = users;
    }

}
