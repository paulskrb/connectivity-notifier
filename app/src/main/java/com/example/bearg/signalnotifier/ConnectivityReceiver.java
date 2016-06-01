package com.example.bearg.signalnotifier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by bearg on 5/31/2016.
 */
public class ConnectivityReceiver extends BroadcastReceiver {

    // monitor for changes in network connectivity
    @Override
    public void onReceive(Context context, Intent intent) {

        boolean networkIsAvailable = intent.getBooleanExtra(
                ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

        if (networkIsAvailable) {
            Uri notification = RingtoneManager.getDefaultUri(
                    RingtoneManager.TYPE_NOTIFICATION);

            MediaPlayer player = MediaPlayer.create(context, notification);
            player.start();

        }
    }


}
