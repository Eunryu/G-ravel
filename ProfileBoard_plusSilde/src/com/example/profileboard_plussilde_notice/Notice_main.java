package com.example.profileboard_plussilde_notice;

import java.util.ArrayList;
import java.util.Collections;

import com.example.profileboard_plussilde.R;
import com.example.profileboard_plussilde_animation.CloseAnimation;
import com.example.profileboard_plussilde_animation.OpenAnimation;
import com.example.profileboard_plussilde_settingGroup.SettingGroup_main;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Notice_main extends Activity{

	static final String TAG="Activity_state";
	//테스트 할 가상 배열 만듬
	private String[] V_title = {"1번째 글","2번째 글","3번째 글","4번째 글","5번째 글","6번째 글","7번째 글","8번째 글","9번째 글","10번째 글"};
	private String[] V_date = {"2014.09.22","2014.09.22","2014.09.22","2014.09.22","2014.09.23","2014.09.23","2014.09.23","2014.09.24","2014.09.24","2014.09.24"};
	private String[] V_writer = {"m","m","m","m","m","m","m","m","m","m"};
	private String[] V_message = {"none1","none2","none3","none4","none5","none6","none7","none8","none9","none10"};
	private ListViewAdapter mAdapter = null;
	
	/* slide menu */
	private DisplayMetrics metrics;
	private LinearLayout ll_SettingAllMenu_mainLayout;
	private LinearLayout ll_SettingAllMenu_menuLayout;
	private FrameLayout.LayoutParams leftMenuLayoutPrams;
	private int leftMenuWidth;
	private static boolean isLeftExpanded;
	private int i;
//	ListViewAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notice_main);
		
//		adapter = new ListViewAdapter(Notice_main.this);
		//adapter = null;
		
		final ListView lv_NoticeMain_MainList = (ListView)findViewById(R.id.lv_NoticeMain_MainList);
		mAdapter = new ListViewAdapter(Notice_main.this);
		lv_NoticeMain_MainList.setAdapter(mAdapter);
		
//		int i;
		
		for(i=0;i<V_title.length;i++){
			mAdapter.addItem(V_title[i], V_message[i], V_date[i], V_writer[i]);
		}
		lv_NoticeMain_MainList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				ListData mData = mAdapter.mListData.get(position);
				Toast.makeText(getApplicationContext(), mData.NoticeTitle, Toast.LENGTH_LONG).show();
				
			}
		});
		
		//검색 스피너
		String[] searchTitle = {"제목","작성자","날짜","내용"};
		ArrayAdapter<String> title = new ArrayAdapter<String>
		(Notice_main.this, android.R.layout.simple_dropdown_item_1line, searchTitle);
		Spinner searchSpinner = (Spinner)findViewById(R.id.sp_NoticeMain_searchSpinner);
		searchSpinner.setAdapter(title);
		
		searchSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String Setting_title = parent.getSelectedItem().toString();
				final EditText search = (EditText)findViewById(R.id.edt_NoticeMain_searchTitle);
				Button btn_search = (Button)findViewById(R.id.btn_NoticeMain_search);
				
				if(Setting_title.equals("제목")){
					btn_search.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							ListViewAdapter adapter = new ListViewAdapter(Notice_main.this);
							String title = search.getText().toString();
							for(i=0;i<V_title.length;i++){
								if(V_title[i].matches(".*"+title+".*")){
									adapter.addItem(V_title[i], V_message[i], V_date[i], V_writer[i]);
									Log.d("있음", "있어요");
								}
							}
							if(adapter.isEmpty() == true){
								Toast.makeText(getApplicationContext(), "검색결과가 없습니다.", Toast.LENGTH_LONG).show();
							}
							lv_NoticeMain_MainList.setAdapter(adapter);
						}
					});
				}else if(Setting_title.equals("작성자")){
					btn_search.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							ListViewAdapter adapter = new ListViewAdapter(Notice_main.this);
							String title = search.getText().toString();
							for(i=0;i<V_writer.length;i++){
								if(V_writer[i].matches(".*"+title+".*")){
									adapter.addItem(V_title[i], V_message[i], V_date[i], V_writer[i]);
									Log.d("있음", "있어요");
								}
							}
							if(adapter.isEmpty() == true){
								Toast.makeText(getApplicationContext(), "검색결과가 없습니다.", Toast.LENGTH_LONG).show();
							}
							lv_NoticeMain_MainList.setAdapter(adapter);
						}
					});
				}else if(Setting_title.equals("날짜")){
					btn_search.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							ListViewAdapter adapter = new ListViewAdapter(Notice_main.this);
							String title = search.getText().toString();
							for(i=0;i<V_date.length;i++){
								if(V_date[i].matches(".*"+title+".*")){
									adapter.addItem(V_title[i], V_message[i], V_date[i], V_writer[i]);
									Log.d("있음", "있어요");
								}
							}
							if(adapter.isEmpty() == true){
								Toast.makeText(getApplicationContext(), "검색결과가 없습니다.", Toast.LENGTH_LONG).show();
							}
							lv_NoticeMain_MainList.setAdapter(adapter);
						}
					});
				}else if(Setting_title.equals("내용")){
					btn_search.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							ListViewAdapter adapter = new ListViewAdapter(Notice_main.this);
							String title = search.getText().toString();
							for(i=0;i<V_message.length;i++){
								if(V_message[i].matches(".*"+title+".*")){
									adapter.addItem(V_title[i], V_message[i], V_date[i], V_writer[i]);
									Log.d("있음", "있어요");
								}
							}
							if(adapter.isEmpty() == true){
								Toast.makeText(getApplicationContext(), "검색결과가 없습니다.", Toast.LENGTH_LONG).show();
							}
							lv_NoticeMain_MainList.setAdapter(adapter);
						}
					});
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {}
		});
		
		initSildeMenu();
	
		//프래그 먼트
		
		FragmentManager manager = getFragmentManager();
        Fragment frag = manager.findFragmentById(R.id.fg_NoticeMain_frag);
        
        ImageButton go_write = (ImageButton)findViewById(R.id.ibtn_NoticeMain_write);
        go_write.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent go_Note = new Intent(Notice_main.this,Notice_note.class);
				startActivity(go_Note);
			}
		});
        
        //슬라이드 메뉴 버튼 테스트
        Button btn_AllSidemenu_Setting = (Button)findViewById(R.id.btn_AllSidemenu_Setting);
        btn_AllSidemenu_Setting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent go_setting = new Intent(Notice_main.this,SettingGroup_main.class);
				startActivity(go_setting);
				finish();
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
		// TODO Auto-generated method stub
		if(item.getItemId() == R.id.item_slide){
			menuLeftSlideAnimationToggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
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
	    private class ViewHolder {
			public TextView NoticeTitle;
			public TextView NoticeMessage;
			public TextView NoticeDate;
			public TextView NoticeWriter;
		}
		private class ListViewAdapter extends BaseAdapter{
			private Context mContext = null;
			private ArrayList<ListData> mListData = new ArrayList<ListData>();
			
			public ListViewAdapter(Context mContext){
				super();
				this.mContext = mContext;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mListData.size();
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return mListData.get(position);
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			public void addItem(String NoticeTitle, String NoticeMessage, 
					String NoticeDate, String NoticeWriter){
				ListData addInfo = null;
				addInfo = new ListData();
				addInfo.NoticeDate = NoticeDate;
				addInfo.Noticemessage = NoticeMessage;
				addInfo.NoticeTitle = NoticeTitle;
				addInfo.NoticeWriter = NoticeWriter;
				
				mListData.add(addInfo);
			}
			
			public void remove(int position){
				mListData.remove(position);
				dataChange();
			}
			
			public void sort(){
				Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
				dataChange();
			}
			
			public void dataChange(){
				mAdapter.notifyDataSetChanged();
			}
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				ViewHolder holder;
				if(convertView == null){
					holder = new ViewHolder();
					
					LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = inflater.inflate(R.layout.noticemain_customlist, null);
					
					holder.NoticeTitle = (TextView)convertView.findViewById(R.id.Listtv_NoticeMain_Title);
					holder.NoticeMessage = (TextView)convertView.findViewById(R.id.Listtv_NoticeMain_Message);
					holder.NoticeDate = (TextView)convertView.findViewById(R.id.Listtv_NoticeMain_Date);
					holder.NoticeWriter = (TextView)convertView.findViewById(R.id.Listtv_NoticeMain_Writer);
					
					convertView.setTag(holder);
				}else{
					holder = (ViewHolder)convertView.getTag();
				}
				
				ListData mData = mListData.get(position);
				holder.NoticeTitle.setText(mData.NoticeTitle);
				holder.NoticeMessage.setText(mData.Noticemessage);
				holder.NoticeDate.setText(mData.NoticeDate);
				holder.NoticeWriter.setText(mData.NoticeWriter);
				
				return convertView;
			}
			
		}
		@Override
		protected void onStart() {
			// TODO Auto-generated method stub
			Log.i(TAG, "onStart");
			super.onStart();
		}
		
		@Override
		protected void onStop() {
			// TODO Auto-generated method stub
			Log.i(TAG, "onStop");
			super.onStop();
		}
}
