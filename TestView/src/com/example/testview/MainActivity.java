package com.example.testview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

//현재 이 예제는 버튼누르면 앞뒤로 왔다갔다 하게만 해놨음.
//인터넷 찾아보니 아직도 탭 호스트를 쓰는 모양... 곧 사라진다 들은거 같은데..
//회의때 다른 방법이 있나 다같이 찾아보도록 할 예정.
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final ViewFlipper viewFlipper = (ViewFlipper)findViewById(R.id.testView);
        Button btn1 = (Button)findViewById(R.id.test1);
        Button btn2 = (Button)findViewById(R.id.test2);
        
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewFlipper.showPrevious();
			}
		});
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewFlipper.showNext();
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
