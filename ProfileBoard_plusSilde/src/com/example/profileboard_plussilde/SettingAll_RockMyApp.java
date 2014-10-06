package com.example.profileboard_plussilde;

import com.example.profileboard_plussilde_static.Rock_static;
import com.example.profileboard_plussilde.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

public class SettingAll_RockMyApp extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingall_rockmyapp);
		
		getActionBar().setTitle("암호잠금");
		
		//객체화
		Switch sh_SettingRockMyapp_RockOnOff = (Switch)findViewById(R.id.sh_SettingRockMyapp_RockOnOff);
		
		//온,오프 확인
		final Rock_static Rstatic = (Rock_static)getApplicationContext();
		
		if(Rstatic.getstate() == "OFF" || Rstatic.getstate() == ""){
			sh_SettingRockMyapp_RockOnOff.setChecked(false);
		}
	
		//스위치 기능
		sh_SettingRockMyapp_RockOnOff.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				String str = String.valueOf(isChecked);
//				Rock_Static Rstatic = (Rock_Static)getApplicationContext();
				
				if(isChecked){
					Toast.makeText(SettingAll_RockMyApp.this, "암호를 설정합니다.", Toast.LENGTH_LONG).show();
					Intent go_settingSecret = new Intent(SettingAll_RockMyApp.this,Setting_IntoPassword.class);
					startActivity(go_settingSecret);
					Rstatic.setstate("ON");
					finish();
				}
				else{
					Toast.makeText(SettingAll_RockMyApp.this, "취소되었음", Toast.LENGTH_LONG).show();
					Rstatic.setstate("OFF");
				}
			}
		});
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.administor, menu);
        return true;
    }
}
