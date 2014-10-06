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
		
		getActionBar().setTitle("��ȣ���");
		
		//��üȭ
		Switch sh_SettingRockMyapp_RockOnOff = (Switch)findViewById(R.id.sh_SettingRockMyapp_RockOnOff);
		
		//��,���� Ȯ��
		final Rock_static Rstatic = (Rock_static)getApplicationContext();
		
		if(Rstatic.getstate() == "OFF" || Rstatic.getstate() == ""){
			sh_SettingRockMyapp_RockOnOff.setChecked(false);
		}
	
		//����ġ ���
		sh_SettingRockMyapp_RockOnOff.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				String str = String.valueOf(isChecked);
//				Rock_Static Rstatic = (Rock_Static)getApplicationContext();
				
				if(isChecked){
					Toast.makeText(SettingAll_RockMyApp.this, "��ȣ�� �����մϴ�.", Toast.LENGTH_LONG).show();
					Intent go_settingSecret = new Intent(SettingAll_RockMyApp.this,Setting_IntoPassword.class);
					startActivity(go_settingSecret);
					Rstatic.setstate("ON");
					finish();
				}
				else{
					Toast.makeText(SettingAll_RockMyApp.this, "��ҵǾ���", Toast.LENGTH_LONG).show();
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
