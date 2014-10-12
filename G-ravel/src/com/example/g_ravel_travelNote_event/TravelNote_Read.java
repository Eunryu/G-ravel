package com.example.g_ravel_travelNote_event;

import com.example.g_ravel.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TravelNote_Read extends Activity{

	private String[] list = {"1","2","3","4","5","6","7","8","9","10"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.travelnote_read);
		
		//¸®½ºÆ®ºä
		ListView listView = (ListView)findViewById(R.id.lv_TravelNoteRead_comment);
		ArrayAdapter<String> NoteList = new ArrayAdapter<String>
		(TravelNote_Read.this, android.R.layout.simple_dropdown_item_1line, list);
		listView.setAdapter(NoteList);
	}
}
