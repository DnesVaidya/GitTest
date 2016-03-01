package com.example.dns.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dns.todolist.Extra.DBHelper;
import com.example.dns.todolist.module.RecycleViewAdapter;
import com.example.dns.todolist.module.Todolist;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper mydb;
    RecycleViewAdapter rViewAdapter;
    MenuItem editMenu, deleteMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DisplayContact.class));
            }
        });

        mydb = new DBHelper(this);
        ArrayList<Todolist> contact_list = mydb.listForRecycleView();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecycleViewAdapter(contact_list, R.id.listView1));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        rViewAdapter = new RecycleViewAdapter(contact_list, R.id.listView1);
        rViewAdapter.setOnItemClickListener(new RecycleViewAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                //rViewAdapter.notifyItemChanged(position);
                rViewAdapter.list.get(position).isEdit = true;
                Log.d("boolean",rViewAdapter.list.get(position).isEdit+""+position );
                rViewAdapter.notifyItemChanged(position);

                editMenu.setVisible(true);
                deleteMenu.setVisible(true);
                //startActionMode(mActionModeCallback);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_click_menu, menu);
        editMenu = (MenuItem) menu.findItem(R.id.editMenu);
        deleteMenu = (MenuItem) menu.findItem(R.id.deleteMenu);
        return true;
    }

    /* private ActionMode.Callback mActionModeCallback = new ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.item_click_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            //mActionModeCallback = null;
        }
    };*/

}
