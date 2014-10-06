package com.example.profileboard_plussilde;

import com.example.profileboard_plussilde_static.Rock_static;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class Setting_IntoPassword extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingall_intopassword);
		
		getActionBar().setTitle("암호설정");
	}
	public boolean onKeyDown(int KeyCode, KeyEvent event){
		if(KeyCode == KeyEvent.KEYCODE_BACK){
			Rock_static rs = (Rock_static)getApplicationContext();
			rs.setstate("OFF");
			Intent go_back = new Intent(Setting_IntoPassword.this,SettingAll_RockMyApp.class);
			startActivity(go_back);
			finish();
		}
		return true;
	}

}
