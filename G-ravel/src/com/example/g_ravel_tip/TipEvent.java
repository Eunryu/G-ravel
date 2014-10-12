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
		
		//����,��縦 ���� �迭�� ���� �� �ƴ��Ϳ� �ֱ�
		String[] Canival = {"����1","����2","����3","����4","����5"};
		String[] Event = {"���1","���2","���3","���4","���5"};
		String[] spinner = {"���","����"};
		
		ArrayAdapter<String> SpinnerList = new ArrayAdapter<String>
		(TipEvent.this, android.R.layout.simple_dropdown_item_1line, spinner);
		final ArrayAdapter<String> List_Canival = new ArrayAdapter<String>
		(TipEvent.this, android.R.layout.simple_dropdown_item_1line, Canival);
		final ArrayAdapter<String> List_Event = new ArrayAdapter<String>
		(TipEvent.this, android.R.layout.simple_dropdown_item_1line, Event);
				
		//���ǳ�,����Ʈ�� ����
		Spinner choiceSpinner = (Spinner)findViewById(R.id.sp_TipEvent_list);
		choiceSpinner.setAdapter(SpinnerList);
		final ListView CE_List = (ListView)findViewById(R.id.lv_TipEvent_list);
		
		//���ǳʸ� ���� ����Ʈ ����
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
