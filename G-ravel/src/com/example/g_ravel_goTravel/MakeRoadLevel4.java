package com.example.g_ravel_goTravel;

import com.example.g_ravel.MemberMain;
import com.example.g_ravel.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MakeRoadLevel4 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.makeroad_level4);
		
		//버튼선언
		Button add = (Button)findViewById(R.id.btn_MakeRoadLevel5_add);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent go_main = new Intent(MakeRoadLevel4.this,MemberMain.class);
				startActivity(go_main);
				finish();
			}
		});
	}
}
