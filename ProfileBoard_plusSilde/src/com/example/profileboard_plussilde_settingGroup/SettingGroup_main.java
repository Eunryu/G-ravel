package com.example.profileboard_plussilde_settingGroup;

import com.example.profileboard_plussilde.R;
import com.example.profileboard_plussilde_animation.CloseAnimation;
import com.example.profileboard_plussilde_animation.OpenAnimation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class SettingGroup_main extends Activity implements OnClickListener{

	/* slide menu */
	private DisplayMetrics metrics;
	private LinearLayout ll_SettingAllMenu_mainLayout;
	private LinearLayout ll_SettingAllMenu_menuLayout;
	private FrameLayout.LayoutParams leftMenuLayoutPrams;
	private int leftMenuWidth;
	private static boolean isLeftExpanded;
	private int i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settinggroup_main);
		
		getActionBar().setTitle("모임설정");
		
		//버튼선언
		Button btn_SettingGroup_RingSetting = (Button)findViewById(R.id.btn_SettingGroup_RingSetting);
		Button btn_SettingGroup_SettingopenRange = (Button)findViewById(R.id.btn_SettingGroup_SettingopenRange);
		Button btn_SettingGroup_ExitGroup = (Button)findViewById(R.id.btn_SettingGroup_ExitGroup);
		
		//기능주기
		btn_SettingGroup_RingSetting.setOnClickListener(this);
		btn_SettingGroup_SettingopenRange.setOnClickListener(this);
		btn_SettingGroup_ExitGroup.setOnClickListener(this);
		
		//슬라이드 메뉴
		initSildeMenu();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_SettingGroup_RingSetting){
			Intent go_settingRing = new Intent(SettingGroup_main.this,SettingGroup_RingSetting.class);
			startActivity(go_settingRing);
		}else if(v.getId() == R.id.btn_SettingGroup_SettingopenRange){
			Intent go_SettingOpenRange = new Intent(SettingGroup_main.this,SettingGroup_SettingOpenRange.class);
			startActivity(go_SettingOpenRange);
		}else if(v.getId() == R.id.btn_SettingGroup_ExitGroup){
			AlertDialog.Builder ExitNavi = new AlertDialog.Builder(SettingGroup_main.this);
			ExitNavi.setTitle("모임 탈퇴");
			ExitNavi.setMessage("모임에서 탈퇴하시겠습니까?");
			ExitNavi.setPositiveButton("네", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			ExitNavi.setNegativeButton("아니오", null);
			ExitNavi.show();
		}
	}
	//슬라이드 메뉴 메소드
		private void initSildeMenu(){
		    	
		    	//init left menu width
		    	metrics = new DisplayMetrics();
		    	getWindowManager().getDefaultDisplay().getMetrics(metrics);
		    	leftMenuWidth = (int) ((metrics.widthPixels) * 0.75);
		    	
		    	//init main view
		    	ll_SettingAllMenu_mainLayout = (LinearLayout)findViewById(R.id.ll_SettingAllMain_mainlayout);
		    	
		    	//init left menu
		    	ll_SettingAllMenu_menuLayout = (LinearLayout)findViewById(R.id.ll_SettingAllMain_menuLayout);
		    	leftMenuLayoutPrams = (FrameLayout.LayoutParams)ll_SettingAllMenu_menuLayout.getLayoutParams();
		    	leftMenuLayoutPrams.width = leftMenuWidth;
		    	ll_SettingAllMenu_menuLayout.setLayoutParams(leftMenuLayoutPrams);

		    }
		    
		    //토글 동작 함수
		    private void menuLeftSlideAnimationToggle(){
		    	if(!isLeftExpanded){
		    		isLeftExpanded = true;
		    		
		    		//Expand
		    		new OpenAnimation(ll_SettingAllMenu_mainLayout, leftMenuWidth,
		    				Animation.RELATIVE_TO_SELF, 0.0f, 
		    				Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);
		    		
		    		//disable all of main view
		    		FrameLayout viewGroup = (FrameLayout)findViewById(R.id.ll_SettingAllMenu_fragment).getParent();
		    		enableDisableViewGroup(viewGroup, false);
		    		
		    		//enable empty view
		    		((LinearLayout)findViewById(R.id.ll_SettingAllMenu_empty)).setVisibility(View.VISIBLE);
		    		((LinearLayout)findViewById(R.id.ll_SettingAllMenu_fragment)).setVisibility(View.INVISIBLE);
		    		findViewById(R.id.ll_SettingAllMenu_empty).setEnabled(true);
		    		findViewById(R.id.ll_SettingAllMenu_empty).setOnTouchListener(new OnTouchListener() {
						
						@Override
						public boolean onTouch(View v, MotionEvent event) {
							// TODO Auto-generated method stub
							return false;
						}
					} );
		    	}else{
		    		isLeftExpanded = false;
		    		
		    		//close
		    		new CloseAnimation(ll_SettingAllMenu_mainLayout, leftMenuWidth, 
		    				TranslateAnimation.RELATIVE_TO_SELF, 0.75f, 
		    				TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);
		    		
		    		//enable all of main view
		    		FrameLayout viewGroup = (FrameLayout)findViewById(R.id.ll_SettingAllMenu_fragment).getParent();
		    		enableDisableViewGroup(viewGroup, true);
		    		
		    		//disable empty view
		    		((LinearLayout)findViewById(R.id.ll_SettingAllMenu_empty)).setVisibility(View.GONE);
		    		findViewById(R.id.ll_SettingAllMenu_empty).setEnabled(false);
		    		
		    		((LinearLayout)findViewById(R.id.ll_SettingAllMenu_fragment)).setVisibility(View.VISIBLE);
		    	}
		    }
		    
		    public static void enableDisableViewGroup(ViewGroup viewGroup,boolean enabled){
		    	int childCount = viewGroup.getChildCount();
		    	for(int i = 0; i < childCount; i++){
		    		View view = viewGroup.getChildAt(i);
		    		if(view.getId() != R.id.item_slide){
		    			view .setEnabled(enabled);
		    			if(view instanceof ViewGroup){
		    				enableDisableViewGroup((ViewGroup) view, enabled);
		    			}
		    		}
		    	}
		    }
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == R.id.item_slide){
			menuLeftSlideAnimationToggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
