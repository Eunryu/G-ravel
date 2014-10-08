package com.example.g_ravel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IdpwSearch extends Activity implements OnClickListener{

	private View v[] = new View[2];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_idpw);
		
		//버튼선언
		Button idSearch = (Button)findViewById(R.id.btn_IdpwSearch_idSearchTitle);
		Button pwSearch = (Button)findViewById(R.id.btn_IdpwSearch_pwSearchTitle);
		
		v[0] = findViewById(R.id.ic_IdpwSearch_idSearch);
		v[1] = findViewById(R.id.ic_IdpwSearch_pwSearch);
		
		//초기상태
		v[0].setVisibility(View.VISIBLE);
		v[1].setVisibility(View.INVISIBLE);
		
		idSearch.setOnClickListener(this);
		pwSearch.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_IdpwSearch_idSearchTitle){
			this.v[0].setVisibility(View.VISIBLE);
			this.v[1].setVisibility(View.INVISIBLE);
		}else if(v.getId() == R.id.btn_IdpwSearch_pwSearchTitle){
			this.v[0].setVisibility(View.INVISIBLE);
			this.v[1].setVisibility(View.VISIBLE);
		}
	}
}
