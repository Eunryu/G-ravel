package com.example.g_ravel_32bit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JoinWrite extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.join_write);
		
		//버튼선언
		Button Next = (Button)findViewById(R.id.btn_JoinWriter_Next);
		Button Cancle = (Button)findViewById(R.id.btn_JoinWriter_cancle);
		
		//버튼 기능주기
		Next.setOnClickListener(this);
		Cancle.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_JoinWriter_Next){
			Intent go_next = new Intent(JoinWrite.this,CheckMe.class);
			startActivity(go_next);
			finish();
		}else if(v.getId() == R.id.btn_JoinWriter_cancle){
			
		}
	}
}
