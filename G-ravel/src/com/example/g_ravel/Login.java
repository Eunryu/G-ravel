package com.example.g_ravel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		//��ư����
		Button join = (Button)findViewById(R.id.btn_Login_join);
		Button searchIdpw = (Button)findViewById(R.id.btn_Login_idpwSearch);
		Button MemberLogin = (Button)findViewById(R.id.btn_Login_login);
		Button GuestLogin = (Button)findViewById(R.id.btn_Login_nonlogin);
		
		//��ư ����ֱ�
		join.setOnClickListener(this);
		searchIdpw.setOnClickListener(this);
		MemberLogin.setOnClickListener(this);
		GuestLogin.setOnClickListener(this);
	}

	//��ư ��Ŭ�� ������
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_Login_join){
			Intent go_join = new Intent(Login.this,Agreement.class);
			startActivity(go_join);
		}else if(v.getId() == R.id.btn_Login_idpwSearch){
			Intent go_idpwSearch = new Intent(Login.this,IdpwSearch.class);
			startActivity(go_idpwSearch);
		}else if(v.getId() == R.id.btn_Login_login){
			Intent go_main = new Intent(Login.this,MemberMain.class);
			startActivity(go_main);
			finish();
		}else if(v.getId() == R.id.btn_Login_nonlogin){
			
		}
	}
}
