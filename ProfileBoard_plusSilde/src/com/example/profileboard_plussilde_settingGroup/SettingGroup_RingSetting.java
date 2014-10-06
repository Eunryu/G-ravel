package com.example.profileboard_plussilde_settingGroup;

import com.example.profileboard_plussilde.R;
import com.example.profileboard_plussilde_SQLite.SettingGroup_SQLite;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

public class SettingGroup_RingSetting extends Activity implements OnCheckedChangeListener{

	private String NoticeBell_memory;
	private String DailyBell_memory;
	private String FreeBoardBell_memory;
	private SettingGroup_SQLite set = new SettingGroup_SQLite(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settinggroup_ringsetting);
		
		getActionBar().setTitle("알림설정");
		
		final Vibrator mVibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
		//테스트용 임시버튼
		Button test = (Button)findViewById(R.id.btn_SettingGroupRingSetting_Test);
		test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					SQLiteDatabase sqldelete;
					sqldelete = set.getWritableDatabase();
					set.onUpgrade(sqldelete, 1, 1);
					Toast.makeText(SettingGroup_RingSetting.this, "성공", Toast.LENGTH_SHORT).show();
					mVibe.vibrate(500);
				}catch(Exception e){
					Toast.makeText(SettingGroup_RingSetting.this, "실패", Toast.LENGTH_SHORT).show();
					Log.d("실패", e.toString());
				}
			}
		});
		
		try{
			SQLiteDatabase readsqlDB;		
			readsqlDB = set.getReadableDatabase();
			Cursor cursor = readsqlDB.rawQuery("SELECT NoticeBell,DailyBell,FreeBoardBell FROM SettingGroup", null);
			while(cursor.moveToNext()){
				NoticeBell_memory = cursor.getString(0);
				Log.d("있음", NoticeBell_memory);
				DailyBell_memory = cursor.getString(1);
				Log.d("있음", DailyBell_memory);
				FreeBoardBell_memory = cursor.getString(2);
				Log.d("있음", FreeBoardBell_memory);
				
			}
			cursor.close();
			readsqlDB.close();
			Toast.makeText(getApplicationContext(), "불러오기 완료", Toast.LENGTH_LONG).show();
		}catch(Exception e){
			Log.d("없대니까", e.toString());
		}
		
		//셋다 불렸는지 로그로 테스트
		Log.d("공지알림", NoticeBell_memory);
		Log.d("일정알림", DailyBell_memory);
		Log.d("게시판 알림", FreeBoardBell_memory);
		
		//스위치의 온오프를 체크.
		//스위치 불러오기
		Switch noticeBell = (Switch)findViewById(R.id.sh_SettingGroupRingSetting_noticeBell);
		Switch dailyBell = (Switch)findViewById(R.id.sh_SettingGroupRingSetting_dailyBell);
		Switch freeboardBell = (Switch)findViewById(R.id.sh_SettingGroupRingSetting_freeboardBell);
		noticeBell.setOnCheckedChangeListener(this);
		dailyBell.setOnCheckedChangeListener(this);
		freeboardBell.setOnCheckedChangeListener(this);
		
		//SQLite 에서 가져온 값으로 일단 스위치에 적용
		
		//공지알림
		if(NoticeBell_memory.equals("ON")){
			noticeBell.setChecked(true);
		}else if(NoticeBell_memory.equals("OFF")){
			noticeBell.setChecked(false);
		}
		//일정알림
		if(DailyBell_memory.equals("ON")){
			dailyBell.setChecked(true);
		}else if(DailyBell_memory.equals("OFF")){
			dailyBell.setChecked(false);
		}
		//게시판 알림
		if(FreeBoardBell_memory.equals("ON")){
			freeboardBell.setChecked(true);
		}else if(FreeBoardBell_memory.equals("OFF")){
			freeboardBell.setChecked(false);
		}
		
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		SQLiteDatabase writeDB;
		writeDB = set.getWritableDatabase();
		
		//이 아래부터는 디비값 변경.
		if(buttonView.getId() == R.id.sh_SettingGroupRingSetting_noticeBell){
			if(isChecked == false){
				String sql = "UPDATE SettingGroup SET NoticeBell = '"+ "OFF" +"';";
				writeDB.execSQL(sql);
			}else if(isChecked == true){
				String sql = "UPDATE SettingGroup SET NoticeBell = '"+ "ON" +"';";
				writeDB.execSQL(sql);
			}
		}else if(buttonView.getId() == R.id.sh_SettingGroupRingSetting_dailyBell){
			if(isChecked == false){
				String sql = "UPDATE SettingGroup SET DailyBell = '"+ "OFF" +"';";
				writeDB.execSQL(sql);
			}else if(isChecked == true){
				String sql = "UPDATE SettingGroup SET DailyBell = '"+ "ON" +"';";
				writeDB.execSQL(sql);
			}
		}else if(buttonView.getId() == R.id.sh_SettingGroupRingSetting_freeboardBell){
			if(isChecked == false){
				String sql = "UPDATE SettingGroup SET FreeBoardBell = '"+ "OFF" +"';";
				writeDB.execSQL(sql);
			}else if(isChecked == true){
				String sql = "UPDATE SettingGroup SET FreeBoardBell = '"+ "ON" +"';";
				writeDB.execSQL(sql);
			}
		}
	}
}