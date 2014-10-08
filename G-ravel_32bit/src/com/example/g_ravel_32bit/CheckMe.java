package com.example.g_ravel_32bit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CheckMe extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkme);
		
		//버튼선언
		Button Ok = (Button)findViewById(R.id.btn_Checkme_check);
		Button Cancle = (Button)findViewById(R.id.btn_Checkme_cancle);
		
		//버튼 기능주기
		Ok.setOnClickListener(this);
		Cancle.setOnClickListener(this);
	}

	//온클릭 리스너
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_Checkme_check){
			Toast.makeText(getApplicationContext(), "인증되었습니다.", Toast.LENGTH_SHORT).show();
//			Intent go_login = new Intent(CheckMe.this,Login.class);
//			startActivity(go_login);
			finish();
		}else if(v.getId() == R.id.btn_Checkme_cancle){
			
		}
	}
}
