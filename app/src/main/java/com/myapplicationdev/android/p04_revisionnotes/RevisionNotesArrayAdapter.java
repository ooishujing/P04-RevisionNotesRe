package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	Context context;
	ArrayList<Note> notes;
	int resource;
	ImageView iv1, iv2, iv3, iv4, iv5;
	TextView tvNote;


	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
		super(context, resource, notes);
		this.context = context;
		this.notes = notes;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(resource, parent, false);

		//Match the UI components with Java variables
		tvNote = rowView.findViewById(R.id.textViewNote);
		iv1 = rowView.findViewById(R.id.imageView1star);
		iv2 = rowView.findViewById(R.id.imageView2star);
		iv3 = rowView.findViewById(R.id.imageView3star);
		iv4 = rowView.findViewById(R.id.imageView4star);
		iv5 = rowView.findViewById(R.id.imageView5star);
		Note note = notes.get(position);

		tvNote.setText("Item: " + note.getId());
		//Check if the property for starts >= 5, if so, "light" up the stars
		if (note.getStars() >= 5) {
			if (note.getStars() == 1) {
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
				iv2.setImageResource(android.R.drawable.btn_star_big_off);
				iv3.setImageResource(android.R.drawable.btn_star_big_off);
				iv4.setImageResource(android.R.drawable.btn_star_big_off);
				iv5.setImageResource(android.R.drawable.btn_star_big_off);
			}
			else if (note.getStars() == 2) {
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
				iv3.setImageResource(android.R.drawable.btn_star_big_off);
				iv4.setImageResource(android.R.drawable.btn_star_big_off);
				iv5.setImageResource(android.R.drawable.btn_star_big_off);
			}
			else if (note.getStars() == 3) {
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
				iv3.setImageResource(android.R.drawable.btn_star_big_on);
				iv4.setImageResource(android.R.drawable.btn_star_big_off);
				iv5.setImageResource(android.R.drawable.btn_star_big_off);
			}
			else if (note.getStars() == 4) {
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
				iv3.setImageResource(android.R.drawable.btn_star_big_on);
				iv4.setImageResource(android.R.drawable.btn_star_big_on);
				iv5.setImageResource(android.R.drawable.btn_star_big_off);
			}
			else {
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
				iv3.setImageResource(android.R.drawable.btn_star_big_on);
				iv4.setImageResource(android.R.drawable.btn_star_big_on);
				iv5.setImageResource(android.R.drawable.btn_star_big_on);
			}
		}

		return rowView;
	}
}
