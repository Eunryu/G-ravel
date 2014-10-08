package com.example.g_ravel_goTravel;

import com.example.g_ravel.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class BestRoadLevel3 extends Activity{

	//����Ʈ�並 ���� ��Ʈ�� ���̰�	
	private String[] list = {"1","2","3","4","5","6","7","8","9","10"};
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bestroad_level3);
		
		ArrayAdapter<String> aList = new ArrayAdapter<String>(BestRoadLevel3.this, android.R.layout.simple_dropdown_item_1line, list);
		ListView lv_area = (ListView)findViewById(R.id.lv_BestRoadLevel3_PackageList);
		lv_area.setAdapter(aList);
		lv_area.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(position == 0){
					String posi = Integer.toString(position);
					Toast.makeText(getApplicationContext(), posi, Toast.LENGTH_SHORT).show();
					Intent goNext = new Intent(BestRoadLevel3.this,BestRoadLevel4.class);
					startActivity(goNext);
					finish();
				}
			}
		});
	}
}