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
		
		//��ư����
		Button Ok = (Button)findViewById(R.id.btn_Checkme_check);
		Button Cancle = (Button)findViewById(R.id.btn_Checkme_cancle);
		
		//��ư ����ֱ�
		Ok.setOnClickListener(this);
		Cancle.setOnClickListener(this);
	}

	//��Ŭ�� ������
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_Checkme_check){
			Toast.makeText(getApplicationContext(), "�����Ǿ����ϴ�.", Toast.LENGTH_SHORT).show();
//			Intent go_login = new Intent(CheckMe.this,Login.class);
//			startActivity(go_login);
			finish();
		}else if(v.getId() == R.id.btn_Checkme_cancle){
			
		}
	}
}
