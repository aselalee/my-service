package com.aselalee.myservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private MyListener myListener = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startMyService(null);
	}

	public void startMyService(View v) {
		Intent intent = new Intent(this, BackgroundService.class);
		startService(intent);
	}

	public void stopMyService(View v) {
		stopService(new Intent(Intent.ACTION_MAIN).setClass(this, BackgroundService.class));
	}

	public void toggleNotificaton(View V) {
		myListener = BackgroundService.GetMyListener();
		if(myListener != null)
			myListener.onStatusChange(0, "My Message");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
