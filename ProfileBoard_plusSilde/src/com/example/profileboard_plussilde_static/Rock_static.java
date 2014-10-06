package com.example.profileboard_plussilde_static;

import android.app.Application;

public class Rock_static extends Application{
	
	private String state;
	
	public void OnCreate(){
		super.onCreate();
		state = null;
	}
	public void OnTerminate(){
		super.onTerminate();
	}
	
	public void setstate(String state){
		this.state = state;
	}
	public String getstate(){
		return state;
	}
}
