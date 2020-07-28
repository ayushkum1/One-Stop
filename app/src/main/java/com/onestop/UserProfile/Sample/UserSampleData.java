package com.onestop.UserProfile.Sample;

import com.onestop.UserProfile.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserSampleData {

    List<UserModel> userList = new ArrayList<>();

    UserModel userModel = new UserModel("Ayush", "Kumar", "8217804700", "ayushkumarsingh06@gmail.com", "https://i.postimg.cc/gc8zy1QF/Ayush-Photo0002.jpg");

    public List<UserModel> getUserList() {

        userList.add(userModel);

        return userList;
    }
}
