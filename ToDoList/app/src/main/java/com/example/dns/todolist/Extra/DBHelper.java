package com.example.dns.todolist.Extra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dns.todolist.module.Todolist;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dns on 2/24/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Contacts.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table contacts (id integer primary key autoincrement, name text,phone text,email text, street text,place text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS contacts";
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean insertContacts (String name, String phone, String email, String street,String place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("email", email);
        values.put("street", street);
        values.put("place", place);
        db.insert("contacts", null, values);
        return true;
    }

    public boolean updateContact (Integer id, String name, String phone, String email, String street,String place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        values1.put("name", name);
        values1.put("phone", phone);
        values1.put("email", email);
        values1.put("street", street);
        values1.put("place", place);
        db.update("contacts", values1, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public boolean deleteContact (Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete("contacts", "id=?", new String[]{Integer.toString(id)});
        return true;
    }

    public ArrayList<String> getAllContacts (){
        ArrayList<String> contactList = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from contacts";
        Cursor res = db.rawQuery(query, null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            contactList.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
            res.moveToNext();
        }
        return contactList;
    }

    public ArrayList<Todolist> listForRecycleView () {
        ArrayList<Todolist> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select id, name, phone from contacts";
        Cursor res = db.rawQuery(query, null);
        if(res!=null && res.moveToFirst()){
            do {
                int id = res.getInt(res.getColumnIndex(CONTACTS_COLUMN_ID));
                String name = res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME));
                String phone = res.getString(res.getColumnIndex(CONTACTS_COLUMN_PHONE));
                Todolist lst = new Todolist(id, name, phone);
                lst.setId(id);
                lst.setName(name);
                lst.setPhone(phone);

                list.add(lst);
            }while (res.moveToNext());
        }
        return  list;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from contacts where id="+id+"";
        Cursor res = db.rawQuery(query, null);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }
}
