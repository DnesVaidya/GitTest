package com.example.dns.leapfrog2.module;

/**
 * Created by Dns on 1/17/2016.
 * TO Put custom Values to List View
 */
public class UserInfo {
    private String user_name, job_title;
    private int image_url;

    public UserInfo(String name, String jobTitle, int avatar) {
        this.user_name = name;
        this.job_title = jobTitle;
        this.image_url = avatar;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }

}
