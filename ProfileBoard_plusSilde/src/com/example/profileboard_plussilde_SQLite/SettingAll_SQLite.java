package com.example.profileboard_plussilde_SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SettingAll_SQLite extends SQLiteOpenHelper{

	public SettingAll_SQLite(Context context) {
		super(context, "SettinAll_DB", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE SettingAll (NoticeBell VARCHAR2(20),DailyBell VARCHAR2(20),FreeBoardBell VARCHAR2(20));";
		db.execSQL(sql);
		String sql2 = "INSERT INTO SettingAll VALUES('"+ "ON" +"','"+ "OFF" +"','"+ "OFF" +"');";
		db.execSQL(sql2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql = "DROP TABLE IF EXISTS SettingAll";
		db.execSQL(sql);
		onCreate(db);
	}

}
