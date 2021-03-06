package com.myapplicationdev.android.p04_revisionnotes;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    Button btnInsert,btnShow,btnFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNote = findViewById(R.id.editTextNote);
        btnShow = findViewById(R.id.buttonShowList);
        btnInsert = findViewById(R.id.buttonInsertNote);
        btnFilter = findViewById(R.id.buttonFilter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GET selected radio button info
                if (String.valueOf(etNote.getText()).trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please fill in revision note",Toast.LENGTH_SHORT).show();
                }else{
                    String note = String.valueOf(etNote.getText());
                    RadioGroup rg = findViewById(R.id.radioGroupStars);
                    int selectedButtonId = rg.getCheckedRadioButtonId();
                    RadioButton rb = findViewById(selectedButtonId);
                    String numberText = String.valueOf(rb.getText());
                    int number = Integer.valueOf(numberText);
                    DBHelper db = new DBHelper(MainActivity.this);

                    db.insertNote(note,number);
                    db.close();
                }



            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("ClickFilter", "false");
                startActivity(intent);
            }
        });
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("ClickFilter", "true");
                startActivity(intent);
            }
        });
    }
}