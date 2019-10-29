package com.e.litterfirebase;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private cards cards_data[];
    private arrayAdapter arrayAdapter;

    private FirebaseAuth mAuth;
    private String currentUid;
    private DatabaseReference usersDb;

    ListView listView;
    ArrayList<cards> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersDb = FirebaseDatabase.getInstance().getReference().child("Users");

        mAuth = FirebaseAuth.getInstance();

        currentUid = mAuth.getCurrentUser().getUid();


        rowItems = new ArrayList<cards>();

        rowItems.add(new cards(currentUid, "Photo1", R.drawable.mu_logo));
        rowItems.add(new cards(currentUid, "Photo2", R.drawable.mu_logo));
        rowItems.add(new cards(currentUid, "Photo3", R.drawable.mu_logo));
        rowItems.add(new cards(currentUid, "Photo4", R.drawable.mu_logo));
        rowItems.add(new cards(currentUid, "Photo5", R.drawable.mu_logo));


        arrayAdapter = new arrayAdapter(this, R.layout.item, rowItems);

        SwipeFlingAdapterView flingContainer = findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {

            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                rowItems.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                cards obj = (cards) dataObject;
                String name = obj.getName();
                usersDb.child("Uid").child(currentUid).child("Swipe").child (name).child("No").child("Reason").setValue(true);
                Toast.makeText(MainActivity.this, "Won't Pick Up", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                cards obj = (cards) dataObject;
                String name = obj.getName();
                usersDb.child("Uid").child(currentUid).child("Swipe").child(name).child("Yes").setValue(true);
                Toast.makeText(MainActivity.this, "Pick Up", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void goToList(View view) {
        Intent intentList = new Intent (MainActivity.this, Nope.class);
        startActivity(intentList);

    }
}
