package com.example.g_ravel_travelNote_event;

import com.example.g_ravel.R;
import com.example.g_ravel_goTravel.MakeRoadLevel2;
import com.example.g_ravel_goTravel.MakeRoadLevel3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Event_main extends Activity{

	private String[] list = {"1","2","3","4","5","6","7","8","9","10"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event);
		
		ArrayAdapter<String> aList = new ArrayAdapter<String>(Event_main.this, android.R.layout.simple_dropdown_item_1line, list);
		ListView lv_area = (ListView)findViewById(R.id.lv_Event_eventInfo);
		lv_area.setAdapter(aList);
		lv_area.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(position == 0){
					String posi = Integer.toString(position);
					Toast.makeText(getApplicationContext(), posi, Toast.LENGTH_SHORT).show();
					Intent goNext = new Intent(Event_main.this,Event_info.class);
					startActivity(goNext);
					finish();
				}
			}
		});
	}
}
