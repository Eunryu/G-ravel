package com.example.g_ravel_32bit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Agreement extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.join_agreement);
		
		//버튼선언
		Button AgreeNext = (Button)findViewById(R.id.btn_Agreement_agreeNext);
		Button NoneAgree = (Button)findViewById(R.id.btn_Agreement_noneAgree);
		
		//버튼 기능주기
		AgreeNext.setOnClickListener(this);
		NoneAgree.setOnClickListener(this);
	}

	//버튼에 기능달아주기
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_Agreement_agreeNext){
			Intent go_writer = new Intent(Agreement.this,JoinWrite.class);
			startActivity(go_writer);
			finish();
		}else if(v.getId() == R.id.btn_Agreement_noneAgree){
			
		}
	}
}
