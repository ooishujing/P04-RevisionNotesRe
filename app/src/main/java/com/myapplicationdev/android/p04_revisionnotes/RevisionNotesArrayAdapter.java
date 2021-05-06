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
	RadioGroup rg;
	RadioButton rb;


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
		rg = rowView.findViewById(R.id.radioGroupStars);
		int selectedButtonId = rg.getCheckedRadioButtonId();
		rb = rowView.findViewById(selectedButtonId);
		Note note = notes.get(position);

		//Check if the property for starts >= 5, if so, "light" up the stars
		if (note.getStars() >= 5) {
			if (note.getStars() == 1) {
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
			}
			else if (note.getStars() == 2) {
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
			}
			else if (note.getStars() == 3) {
				iv3.setImageResource(android.R.drawable.btn_star_big_on);
			}
			else if (note.getStars() == 4) {
				iv4.setImageResource(android.R.drawable.btn_star_big_on);
			}
			else {
				iv5.setImageResource(android.R.drawable.btn_star_big_on);
			}
		}

		return rowView;
	}
}
