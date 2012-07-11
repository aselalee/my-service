package com.aselalee.myservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BackgroundService extends Service implements MyListener{
	private MyThread myServiceThread = null;
	private Notification mNt = null;
	private static boolean isMyServiceStarted;
	private final int ST_L1 = 0;
	private final int ST_L3 = 2;
	private static MyListener myListener;
	private NotificationManager mNM = null;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		isMyServiceStarted = false;
		return START_STICKY;
	}

	private void setNotification() {
		mNt = new Notification(R.drawable.status_level,
				"MyService Ticker Text", System.currentTimeMillis());
		mNt.iconLevel = ST_L1;
		Intent mIn = new Intent(this, MainActivity.class);
		PendingIntent mPIn = PendingIntent.getActivity(this, 0, mIn, 0);
		mNt.setLatestEventInfo(this, "MyService Content Title", "MyService Content Text", mPIn);
		startForeground(1, mNt);
	}

	private void toggleNotificationIcon() {
		mNt.iconLevel++;
		if(mNt.iconLevel > ST_L3) {
			mNt.iconLevel = ST_L1;
		}
		mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		mNM.notify(1, mNt);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
		if(myServiceThread != null) {
			myServiceThread.interrupt();
		}
		isMyServiceStarted = false;
		stopForeground(true);
		myListener = null;
	}

	@Override
	public void onCreate() {
		if(isMyServiceStarted == true){
			return;
		}
		setNotification();
		Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
		myServiceThread = new MyThread();
		myServiceThread.start();
		isMyServiceStarted = true;
		myListener = this;
	}
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	private class MyThread extends Thread {
		@Override
		public void run() {
			super.run();
			while(true) {
				try {
					Thread.sleep(1000);
					Log.i("MyService", "Running...\n");
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}

	public void onStatusChange(int statusID, String statusMsg) {
		toggleNotificationIcon();
	}

	public static MyListener GetMyListener() {
		return myListener;
	}
}
