package com.example.profileboard_plussilde_settingGroup;

import com.example.profileboard_plussilde.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class SettingGroup_SettingOpenRange extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settinggroup_openrange);
		
		getActionBar().setTitle("내정보 공개범위 설정");
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
