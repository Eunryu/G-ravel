package com.example.g_ravel;

import com.example.g_ravel_goTravel.ChooseBigArea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MemberMain extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_member);
		
		//버튼선언
		Button make_travel = (Button)findViewById(R.id.btn_Member_Gotravel);
		Button write_note = (Button)findViewById(R.id.btn_Member_TravelNote);
		Button train_map = (Button)findViewById(R.id.btn_Member_G_train);
		Button world_map = (Button)findViewById(R.id.btn_Member_G_map);
		Button tip = (Button)findViewById(R.id.btn_Member_Tips);
		Button event = (Button)findViewById(R.id.btn_Member_event);
		Button setting = (Button)findViewById(R.id.btn_Member_setting);
		Button myInfo = (Button)findViewById(R.id.btn_Member_myinfo);
		
		make_travel.setOnClickListener(this);
		write_note.setOnClickListener(this);
		train_map.setOnClickListener(this);
		world_map.setOnClickListener(this);
		tip.setOnClickListener(this);
		event.setOnClickListener(this);
		setting.setOnClickListener(this);
		myInfo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_Member_Gotravel){
			Intent go_travel = new Intent(MemberMain.this,ChooseBigArea.class);
			startActivity(go_travel);
		}else if(v.getId() == R.id.btn_Member_TravelNote){
			
		}else if(v.getId() == R.id.btn_Member_G_train){
			
		}else if(v.getId() == R.id.btn_Member_G_map){
			
		}else if(v.getId() == R.id.btn_Member_Tips){
			
		}else if(v.getId() == R.id.btn_Member_event){
			
		}else if(v.getId() == R.id.btn_Member_setting){
			
		}else if(v.getId() == R.id.btn_Member_myinfo){
			
		}
	}
}
