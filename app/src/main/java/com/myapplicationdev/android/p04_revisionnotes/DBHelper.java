package com.myapplicationdev.android.p04_revisionnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

	private Context context;
	//TODO Define the Database properties
	private static final String DATABASE_NAME = "Notes.db";
	private static final int DATABASE_VERSION = 1;

	private static final String TABLE_NOTE = "Note";
	private static final String COLOUMN_ID = "id";
	private static final String COLOUMN_NOTE_CONTENT = "note_content";
	private static final String COLOUMN_STARS = "stars";



	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//TODO CREATE TABLE Note
		String createTableSql = "CREATE TABLE " + TABLE_NOTE + "(" + COLOUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_NOTE_CONTENT + " TEXT, " + COLOUMN_STARS + " INTEGER ) ";
		db.execSQL(createTableSql);
		Log.i("Created?", "Created tables ");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
		onCreate(db);
	}

	public void insertNote(String noteContent, int stars) {
		//TODO insert the data into the database
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLOUMN_NOTE_CONTENT, noteContent);
		values.put(COLOUMN_STARS, stars);
		long result = db.insert(TABLE_NOTE, null,values);
		if (result == -1){
			Toast.makeText(context,"Insert Failed",Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(context,"Inserted",Toast.LENGTH_SHORT).show();
		}
	}

	public ArrayList<Note> getAllNotes() {
		//TODO return records in Java objects
		ArrayList<Note> tasks = new ArrayList<Note>();
		String selectQuery = "SELECT *" + " FROM " + TABLE_NOTE;

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery,null);
		if(cursor.moveToFirst()){
			do{
				int id = cursor.getInt(0);
				String description = cursor.getString(1);
				int stars = cursor.getInt(2);
				Note obj = new Note(id, description, stars);
				tasks.add(obj);
			}while(cursor.moveToNext());

		}
		cursor.close();
		return tasks;
	}

    public ArrayList<String> getNoteContent() {
        //TODO return records in Strings

		// Create an ArrayList that holds String objects
        ArrayList<String> notes = new ArrayList<String>();
        // Select all the notes' content
        String selectQuery = "SELECT * " + "FROM " + TABLE_NOTE;

        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);
        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row and returns true;
            // moveToNext() returns false when no more next row to move to
			notes.add(cursor.getString(0));
            do {


            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return notes;
    }
}
