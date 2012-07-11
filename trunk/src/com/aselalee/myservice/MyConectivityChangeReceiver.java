package com.aselalee.myservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class MyConectivityChangeReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("MyService", "System Contectivity Changed broadcast received.");
		NetworkInfo mNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
		Log.i("MyService", "getExtraInfo(): " + mNetworkInfo.getExtraInfo());
		Log.i("MyService", "getReason(): " + mNetworkInfo.getReason());
		Log.i("MyService", "getTypeName(): " + mNetworkInfo.getTypeName());
		Log.i("MyService", "EXTRA_EXTRA_INFO: " + intent.getStringExtra(ConnectivityManager.EXTRA_EXTRA_INFO));
		Log.i("MyService", "EXTRA_REASON: " + intent.getStringExtra(ConnectivityManager.EXTRA_REASON));
		boolean failover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);
		Log.i("MyService", "EXTRA_IS_FAILOVER: " + String.valueOf(failover));
		boolean noCon = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
		Log.i("MyService", "EXTRA_NO_CONNECTIVITY: " + String.valueOf(noCon));
		
		switch(mNetworkInfo.getState()) {
		case CONNECTED:
			Log.i("MyService: ", "CONNECTED");
			break;
		case CONNECTING:
			Log.i("MyService: ", "CONNECTING");
			break;
		case DISCONNECTED:
			Log.i("MyService: ", "DISCONNECTED");
			break;
		case DISCONNECTING:
			Log.i("MyService: ", "DISCONNECTING");
			break;
		case SUSPENDED:
			Log.i("MyService: ", "SUSPENDED");
			break;
		case UNKNOWN:
			Log.i("MyService: ", "UNKNOWN");
			break;
		default:
			Log.i("MyService: ", "Unidentified State");
		}
	}

}
