package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter<Note> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO implement the Custom ListView
        setContentView(R.layout.activity_second);
        lv = findViewById(R.id.lv);

        Intent intent = getIntent();
        String filter = intent.getStringExtra("ClickFilter");
        DBHelper db = new DBHelper(SecondActivity.this);

        // Insert a task
        ArrayList<Note> data = db.getAllNotes();
        ArrayList<Note> filtered = new ArrayList<Note>();
        for(int i = 0; i < data.size(); i++){
            Note Current = data.get(i);
            if (Current.getStars() >= 3) {
                filtered.add(Current);
            }
        }
        if(filter.equals("true")) {
            aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, filtered);
        }
        else{
            aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, data);
        }
        lv.setAdapter(aa);

        db.close();

        aa.notifyDataSetChanged();
    }
}
