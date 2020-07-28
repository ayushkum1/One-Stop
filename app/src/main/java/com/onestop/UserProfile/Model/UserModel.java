package com.onestop.UserProfile.Model;

public class UserModel {

    String userFname, userLname, userPhone, userEmail, userPhoto;

    public UserModel() {
    }

    public UserModel(String userFname, String userLname, String userPhone, String userEmail, String userPhoto) {
        this.userFname = userFname;
        this.userLname = userLname;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPhoto = userPhoto;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
