package com.e.litterfirebase;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

public class Nope extends AppCompatActivity implements OnOptionSelected{

    private List<NopeObject> nolists;
    private  NopeAdapter nopeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_list);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        nolists=new ArrayList<>();
        for (int i=0;i<20;i++)
        {
            NopeObject nopeObject= new NopeObject();
            nopeObject.setName("Name " + (i + 1));
            nopeObject.setListImage(R.mipmap.ic_launcher);
            nolists.add(nopeObject);
        }
        nopeAdapter =new NopeAdapter();
        nopeAdapter.setOnOptionSelected(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        nopeAdapter.setNolists(nolists);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(nopeAdapter);
    }


    @Override
    public void onOptionSelected(int position, int itemSelected) {
        nolists.get(position).setSelectedAnswerPosition(itemSelected);
        switch (itemSelected){
            case 1:
                nolists.get(position).setOp1Sel(true);
                break;

            case 2:
                nolists.get(position).setOp2Sel(true);
                break;
            case 3:
                (nolists.get(position)).setOp3Sel(true);
                break;
            case 4:
                nolists.get(position).setOp4Sel(true);
                break;

            case 5:
                nolists.get(position).setOp5Sel(true);
                break;
            case 6:
                (nolists.get(position)).setOp6Sel(true);
                break;
        }
        nopeAdapter.setNolists(nolists);
        nopeAdapter.notifyDataSetChanged();
        // mRecyclerView.setAdapter(NopeAdapter);

    }
}