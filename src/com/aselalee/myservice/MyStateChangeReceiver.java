package com.aselalee.myservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyStateChangeReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("MyService", "System Phone State Change broadcast received.");
		Log.i("MyService", "EXTRA_STATE: " + intent.getStringExtra(TelephonyManager.EXTRA_STATE));
		Log.i("MyService", "EXTRA_INCOMING_NUMBER: " + intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER));
	}

}
