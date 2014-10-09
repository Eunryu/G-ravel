package com.example.g_ravel_goTravel;

import com.example.g_ravel.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MakeRoadLevel1 extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.makeroad_level1);
		
		//버튼선언
		Button bed = (Button)findViewById(R.id.btn_MakeRoadLevel1_bed);
		Button eat = (Button)findViewById(R.id.btn_MakeRoadLevel1_eat);
		Button play = (Button)findViewById(R.id.btn_MakeRoadLevel1_play);
		Button see = (Button)findViewById(R.id.btn_MakeRoadLevel1_see);
		Button car = (Button)findViewById(R.id.btn_MakeRoadLevel1_car);
		
		bed.setOnClickListener(this);
		eat.setOnClickListener(this);
		play.setOnClickListener(this);
		see.setOnClickListener(this);
		car.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_MakeRoadLevel1_bed){
			try{
			Intent go_next = new Intent(MakeRoadLevel1.this,MakeRoadLevel2.class);
			startActivity(go_next);
			}catch(Exception e){
				Log.d("오류", e.toString());
			}
		}else if(v.getId() == R.id.btn_MakeRoadLevel1_eat){
			Toast.makeText(getApplicationContext(), "없음", Toast.LENGTH_SHORT).show();
		}else if(v.getId() == R.id.btn_MakeRoadLevel1_see){
			Toast.makeText(getApplicationContext(), "없음", Toast.LENGTH_SHORT).show();
		}else if(v.getId() == R.id.btn_MakeRoadLevel1_play){
			Toast.makeText(getApplicationContext(), "없음", Toast.LENGTH_SHORT).show();
		}else if(v.getId() == R.id.btn_MakeRoadLevel1_car){
			Toast.makeText(getApplicationContext(), "없음", Toast.LENGTH_SHORT).show();
		}
	}
}
