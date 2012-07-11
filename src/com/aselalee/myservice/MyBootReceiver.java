package com.aselalee.myservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("MyService", "System Boot Complete broadcast received.");
		/**
		 * Starts the MyService service.
		 */
//		Intent mIntent = new Intent(context, BackgroundService.class);
//		context.startService(mIntent);
	}

}
