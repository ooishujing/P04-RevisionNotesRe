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
    ArrayList<Note> note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO implement the Custom ListView

        lv = findViewById(R.id.lv);

        DBHelper db = new DBHelper(SecondActivity.this);

        // Insert a task
        ArrayList<Note> data = db.getAllNotes();
        

        db.close();

        aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, note);
        lv.setAdapter(aa);

        aa.notifyDataSetChanged();
    }
}
