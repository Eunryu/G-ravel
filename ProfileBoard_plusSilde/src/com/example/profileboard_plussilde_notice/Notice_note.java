package com.example.profileboard_plussilde_notice;

import com.example.profileboard_plussilde.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Notice_note extends Activity{

	//���ǳ� �迭����
	private String[] mRange = {"��ü����","�μ�����"};
	private String[] mTemplet = {"�Ϲݰ���","�ΰ�","��ȥ","�����","�̺�Ʈ"};
	
	//������ �ҷ����� ���� ���� ����
	final int REQ_PICK_CODE = 100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notice_note);
		
		ArrayAdapter<String> Range = new ArrayAdapter<String>(Notice_note.this, android.R.layout.simple_dropdown_item_1line,
				mRange);
		ArrayAdapter<String> Templet = new ArrayAdapter<String>(Notice_note.this, android.R.layout.simple_dropdown_item_1line,
				mTemplet);
		Spinner lRange = (Spinner)findViewById(R.id.spn_NoticeNote_range);
		Spinner lTemplet = (Spinner)findViewById(R.id.spn_NoticeNote_templet);		
		lRange.setPrompt("�������� ����");
		lTemplet.setPrompt("���ø� ����");
		lRange.setAdapter(Range);
		lTemplet.setAdapter(Templet);
		
		//���� �ҷ�����
		Button addPicture = (Button)findViewById(R.id.btn_NoticeNote_addPicture);
		addPicture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent pickerIntent = new Intent(Intent.ACTION_PICK);
				pickerIntent.setType("image/*");
				startActivityForResult(pickerIntent, REQ_PICK_CODE);
				
			}
		});
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    switch(requestCode) { 
	    case REQ_PICK_CODE:
	        if(resultCode == RESULT_OK){
	            final Uri pickUri = data.getData();
	            String path = pickUri.toString();
	            Toast.makeText(getApplicationContext(), path, Toast.LENGTH_LONG).show();
	        }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
