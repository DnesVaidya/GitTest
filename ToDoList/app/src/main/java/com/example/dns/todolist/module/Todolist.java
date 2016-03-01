package com.example.dns.todolist.module;

/**
 * Created by Dns on 2/26/2016.
 */
public class Todolist {
    private String name, phone;
    private int id;

    public boolean isEdit=false;

    public Todolist(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
