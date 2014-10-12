package com.example.g_ravel_tip;

import com.example.g_ravel.R;
import com.example.g_ravel_goTravel.BestRoadLevel2;
import com.example.g_ravel_goTravel.BestRoadLevel3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TipEvent extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tip_event);
		
		//축제,행사를 위한 배열을 선언 및 아답터에 넣기
		String[] Canival = {"축제1","축제2","축제3","축제4","축제5"};
		String[] Event = {"행사1","행사2","행사3","행사4","행사5"};
		String[] spinner = {"행사","축제"};
		
		ArrayAdapter<String> SpinnerList = new ArrayAdapter<String>
		(TipEvent.this, android.R.layout.simple_dropdown_item_1line, spinner);
		final ArrayAdapter<String> List_Canival = new ArrayAdapter<String>
		(TipEvent.this, android.R.layout.simple_dropdown_item_1line, Canival);
		final ArrayAdapter<String> List_Event = new ArrayAdapter<String>
		(TipEvent.this, android.R.layout.simple_dropdown_item_1line, Event);
				
		//스피너,리스트뷰 선언
		Spinner choiceSpinner = (Spinner)findViewById(R.id.sp_TipEvent_list);
		choiceSpinner.setAdapter(SpinnerList);
		final ListView CE_List = (ListView)findViewById(R.id.lv_TipEvent_list);
		
		//스피너를 따라서 리스트 변경
		choiceSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(position == 0){
					CE_List.setAdapter(List_Event);
				}else if(position == 1){
					CE_List.setAdapter(List_Canival);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {}
		});
	}
}
