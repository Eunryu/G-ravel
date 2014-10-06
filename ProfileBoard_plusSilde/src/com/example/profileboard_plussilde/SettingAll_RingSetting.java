package com.example.profileboard_plussilde;

import com.example.profileboard_plussilde_SQLite.SettingAll_SQLite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

public class SettingAll_RingSetting extends Activity implements OnCheckedChangeListener{

	private String NoticeBell_memory;
	private String DailyBell_memory;
	private String FreeBoardBell_memory;
	private SettingAll_SQLite settingAll = new SettingAll_SQLite(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingall_ringsetting);
		
		getActionBar().setTitle("�˸�����");
		
		try{
			SQLiteDatabase readsqlDB;		
			readsqlDB = settingAll.getReadableDatabase();
			Cursor cursor = readsqlDB.rawQuery("SELECT NoticeBell,DailyBell,FreeBoardBell FROM SettingAll", null);
			while(cursor.moveToNext()){
				NoticeBell_memory = cursor.getString(0);
				Log.d("����", NoticeBell_memory);
				DailyBell_memory = cursor.getString(1);
				Log.d("����", DailyBell_memory);
				FreeBoardBell_memory = cursor.getString(2);
				Log.d("����", FreeBoardBell_memory);
				
			}
			cursor.close();
			readsqlDB.close();
			Toast.makeText(getApplicationContext(), "�ҷ����� �Ϸ�", Toast.LENGTH_LONG).show();
		}catch(Exception e){
			Log.d("����ϱ�", e.toString());
		}
		
		//�´� �ҷȴ��� �α׷� �׽�Ʈ
		Log.d("�����˸�", NoticeBell_memory);
		Log.d("�����˸�", DailyBell_memory);
		Log.d("�Խ��� �˸�", FreeBoardBell_memory);
		
		//����ġ�� �¿��� üũ
		//����ġ �ҷ�����
		Switch noticeBell = (Switch)findViewById(R.id.sh_SettingRingSetting_noticeBell);
		Switch dailyBell = (Switch)findViewById(R.id.sh_SettingRingSetting_dailyBell);
		Switch freeboardBell = (Switch)findViewById(R.id.sh_SettingRingSetting_freeboardBell);
		noticeBell.setOnCheckedChangeListener(this);
		dailyBell.setOnCheckedChangeListener(this);
		freeboardBell.setOnCheckedChangeListener(this);
		
		//SQLite ���� ������ ������ �ϴ� ����ġ�� ����
		
		//�����˸�
		if(NoticeBell_memory.equals("ON")){
			noticeBell.setChecked(true);
		}else if(NoticeBell_memory.equals("OFF")){
			noticeBell.setChecked(false);
		}
		//�����˸�
		if(DailyBell_memory.equals("ON")){
			dailyBell.setChecked(true);
		}else if(DailyBell_memory.equals("OFF")){
			dailyBell.setChecked(false);
		}
		//�Խ��� �˸�
		if(FreeBoardBell_memory.equals("ON")){
			freeboardBell.setChecked(true);
		}else if(FreeBoardBell_memory.equals("OFF")){
			freeboardBell.setChecked(false);
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.administor, menu);
        return true;
    }

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		SQLiteDatabase writeDB;
		writeDB = settingAll.getWritableDatabase();
		
		//�� �Ʒ����ʹ� ��� ����.
		if(buttonView.getId() == R.id.sh_SettingRingSetting_noticeBell){
			if(isChecked == false){
				String sql = "UPDATE SettingAll SET NoticeBell = '"+ "OFF" +"';";
				writeDB.execSQL(sql);
			}else if(isChecked == true){
				String sql = "UPDATE SettingAll SET NoticeBell = '"+ "ON" +"';";
				writeDB.execSQL(sql);
			}
		}else if(buttonView.getId() == R.id.sh_SettingRingSetting_dailyBell){
			if(isChecked == false){
				String sql = "UPDATE SettingAll SET DailyBell = '"+ "OFF" +"';";
				writeDB.execSQL(sql);
			}else if(isChecked == true){
				String sql = "UPDATE SettingAll SET DailyBell = '"+ "ON" +"';";
				writeDB.execSQL(sql);
			}
		}else if(buttonView.getId() == R.id.sh_SettingRingSetting_freeboardBell){
			if(isChecked == false){
				String sql = "UPDATE SettingAll SET FreeBoardBell = '"+ "OFF" +"';";
				writeDB.execSQL(sql);
			}else if(isChecked == true){
				String sql = "UPDATE SettingAll SET FreeBoardBell = '"+ "ON" +"';";
				writeDB.execSQL(sql);
			}
		}
	}
}
