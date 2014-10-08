package com.example.g_ravel_goTravel;

import com.example.g_ravel.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BestRoadLevel1 extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bestroad_level1);
		
		//버튼선언
		Button Healing = (Button)findViewById(R.id.btn_BestRoadLevel1_Healing);
		Button Play = (Button)findViewById(R.id.btn_BestRoadLevel1_work);
		Button family = (Button)findViewById(R.id.btn_BestRoadLevel1_Family);
		Button Date = (Button)findViewById(R.id.btn_BestRoadLevel1_Date);
		Button See = (Button)findViewById(R.id.btn_BestRoadLevel1_SeeArea);
		
		Healing.setOnClickListener(this);
		Play.setOnClickListener(this);
		family.setOnClickListener(this);
		Date.setOnClickListener(this);
		See.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_BestRoadLevel1_Healing){
			Intent go_Healing = new Intent(BestRoadLevel1.this, BestRoadLevel2.class);
			startActivity(go_Healing);
		}
	}
}
