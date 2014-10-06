package com.example.profileboard_plussilde;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class SettingAll_ElectronicBusinessCard extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingall_electronicbusinesscard);
		getActionBar().setTitle("전자명함");
		
		final Button Save_in_mygallery = (Button)findViewById(R.id.btn_SettingElectronicBusinessCard_Save);
		
		//명함 이미지 저장
		ImageView BusinessCard = (ImageView)findViewById(R.id.iv_SettingAllElectronicBusinessCard_image);
		Drawable d = BusinessCard.getDrawable();
		final Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
		Save_in_mygallery.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FileOutputStream out = null;
				
				try{
					out = new FileOutputStream
							(Environment.getExternalStorageDirectory().getPath()+"/명함.png");
					bitmap.compress(Bitmap.CompressFormat.PNG, 50, out);
					String path = Environment.getExternalStorageDirectory().getPath().toString();
					Toast.makeText(SettingAll_ElectronicBusinessCard.this, "저장되었습니다.\n"+ path, Toast.LENGTH_LONG).show();
				}catch(FileNotFoundException error){
					Log.d("오류", error.toString());
			}catch(Exception e){
					Log.d("오류",e.toString());
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
