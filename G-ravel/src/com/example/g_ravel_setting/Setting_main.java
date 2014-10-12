package com.example.g_ravel_setting;

import com.example.g_ravel.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Setting_main extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_main);
		
		//버튼선언
		Button appNotice = (Button)findViewById(R.id.btn_SettingMain_appNotice);
		
		appNotice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent goNotice = new Intent(Setting_main.this,AppNotice.class);
				startActivity(goNotice);
			}
		});
	}
}
