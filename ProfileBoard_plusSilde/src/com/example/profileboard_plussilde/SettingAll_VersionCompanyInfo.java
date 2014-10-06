package com.example.profileboard_plussilde;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SettingAll_VersionCompanyInfo extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingall_versioncompanyinfo);
		
		getActionBar().setTitle("버전정보/회사소개");
		
		//버전비교
		TextView thisVersion = (TextView)findViewById(R.id.tv_SettingVersionCompanyInfo_thisVersion);
		TextView newVersion = (TextView)findViewById(R.id.tv_SettingVersionCompanyInfo_NewVersion);
		String tVersion = thisVersion.getText().toString();
		String nVersion = newVersion.getText().toString();
		
		Button update = (Button)findViewById(R.id.btn_SettingVersionCompanyInfo_Update);
		
		if(tVersion.equals(nVersion)){
			update.setEnabled(false);
		}else{
			update.setEnabled(true);
		}
		
		//구글로 이동됨 ( 현재 테스트로 네이버에 연결되어 있음 )
		//버튼선언은 위쪽에 되어있음.
		update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent google = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.nhn.android.search"));
				startActivity(google);
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
