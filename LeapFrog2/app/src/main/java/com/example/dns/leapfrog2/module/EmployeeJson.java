package com.example.dns.leapfrog2.module;

/**
 * Created by Dns on 2/4/2016.
 */
public class EmployeeJson {
    private String ename, jobTtile;

    public EmployeeJson(String name, String jobTitle) {
        this.ename = name;
        this.jobTtile = jobTitle;
    }

    public String getJobTtile() {
        return jobTtile;
    }

    public void setJobTtile(String jobTtile) {
        this.jobTtile = jobTtile;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    //@Override
    /*public String toString() {
        return this.ename+" "+this.jobTtile;
    }*/
}
