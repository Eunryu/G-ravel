package com.example.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class MainActivity extends Activity implements OnClickListener{
    
	private View v[] = new View[2];
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //버튼선언 됬으니까 인제 스피너에 한번 해볼까 ? ㅎ
        String[] test = {"First","Second"};
        ArrayAdapter<String> testArray = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, test);
        Spinner spinner = (Spinner)findViewById(R.id.TestSpinner);
        spinner.setAdapter(testArray);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(parent.getSelectedItemPosition() == 0){
					v[0].setVisibility(View.VISIBLE);
					v[1].setVisibility(View.INVISIBLE);
				}else if(parent.getSelectedItemPosition() == 1){
					v[0].setVisibility(View.INVISIBLE);
					v[1].setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});

        //버튼선언
        Button btn1 = (Button)findViewById(R.id.btn_test1);
        Button btn2 = (Button)findViewById(R.id.btn_test2);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        
//        View v[] = new View[2];
        v[0] = findViewById(R.id.ViewFirst);
        v[1] = findViewById(R.id.ViewSecond);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_test1){
			this.v[0].setVisibility(View.VISIBLE);
			this.v[1].setVisibility(View.INVISIBLE);
		}else if(v.getId() == R.id.btn_test2){
			this.v[0].setVisibility(View.INVISIBLE);
			this.v[1].setVisibility(View.VISIBLE);
		}
	}
}
