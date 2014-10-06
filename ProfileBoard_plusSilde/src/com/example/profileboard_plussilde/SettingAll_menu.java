package com.example.profileboard_plussilde;

import com.example.profileboard_plussilde_notice.Notice_main;
import com.example.profileboard_plussilde_settingGroup.SettingGroup_main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SettingAll_menu extends Activity implements OnClickListener {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingall_main);
        
      //액션바 이름주기
        getActionBar().setTitle("관리자 메뉴");
        
        //버튼선언
        Button RewriteMyProfile = (Button)findViewById(R.id.btn_SettingAll_RewriteMyProfile);
        Button ElectionBusinessCard = (Button)findViewById(R.id.btn_SettingAll_ElectronicBusinessCard);
        Button RingSetting = (Button)findViewById(R.id.btn_SettingAll_RingSetting);
        Button VersionCompanyInfo = (Button)findViewById(R.id.btn_SettingAll_VersionCompanyInfo);
        Button ExitProfileBoard = (Button)findViewById(R.id.btn_SettingAll_ExitProfileBoard);
        Button RockMyApp = (Button)findViewById(R.id.btn_SettingAll_RockMyapp);
        Button test = (Button)findViewById(R.id.btn_test);
        Button test2 = (Button)findViewById(R.id.btn_test2);
        
        //버튼 이동구현.
        RewriteMyProfile.setOnClickListener(this);
        ElectionBusinessCard.setOnClickListener(this);
        RingSetting.setOnClickListener(this);
        VersionCompanyInfo.setOnClickListener(this);
        ExitProfileBoard.setOnClickListener(this);
        RockMyApp.setOnClickListener(this);
        test.setOnClickListener(this);
        test2.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.administor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_SettingAll_RewriteMyProfile){
			Intent go_RewriteMyProfile = new Intent(SettingAll_menu.this,SettingAll_RewriteMyInfo.class);
			startActivity(go_RewriteMyProfile);
		}else if(v.getId() == R.id.btn_SettingAll_ElectronicBusinessCard){
			Intent go_ElectronicBusinessCard = new Intent(SettingAll_menu.this,SettingAll_ElectronicBusinessCard.class);
			startActivity(go_ElectronicBusinessCard);
		}else if(v.getId() == R.id.btn_SettingAll_RingSetting){
			Intent go_RindSetting = new Intent(SettingAll_menu.this,SettingAll_RingSetting.class);
			startActivity(go_RindSetting);
		}else if(v.getId() == R.id.btn_SettingAll_RockMyapp){
			Intent go_rockMyapp = new Intent(SettingAll_menu.this,SettingAll_RockMyApp.class);
			startActivity(go_rockMyapp);
		}else if(v.getId() == R.id.btn_SettingAll_ExitProfileBoard){
			AlertDialog.Builder ExitNavi = new AlertDialog.Builder(SettingAll_menu.this);
			ExitNavi.setTitle("프로필보드 탈퇴");
			ExitNavi.setMessage("프로필 보드를 탈퇴하시겠습니까?");
			ExitNavi.setPositiveButton("네", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			ExitNavi.setNegativeButton("아니오", null);
			ExitNavi.show();
		}else if(v.getId() == R.id.btn_SettingAll_VersionCompanyInfo){
			Intent go_versionCompanyInfo = new Intent(SettingAll_menu.this,SettingAll_VersionCompanyInfo.class);
			startActivity(go_versionCompanyInfo);
		}else if(v.getId() == R.id.btn_test){
			Intent go_test = new Intent(SettingAll_menu.this,SettingGroup_main.class);
			startActivity(go_test);
		}else if(v.getId() == R.id.btn_test2){
			Intent go_test2 = new Intent(SettingAll_menu.this,Notice_main.class);
			startActivity(go_test2);
		}
	}
}
