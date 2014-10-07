package com.example.g_ravel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class IdpwSearch extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_idpw);
		
		//탭구현
		TabHost tabHost = (TabHost)findViewById(R.id.tabhost);
		tabHost.setup();
		
		TabSpec spec1 = tabHost.newTabSpec("Tab1").setContent(R.id.tab1).setIndicator("id 찾기");
		tabHost.addTab(spec1);
		TabSpec spec2 = tabHost.newTabSpec("Tab2").setContent(R.id.tab2).setIndicator("pw 찾기");
		tabHost.addTab(spec2);
		
		tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 50;
		tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 50;
	}
}
