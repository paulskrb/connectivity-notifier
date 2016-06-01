package com.example.bearg.signalnotifier;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

/**
 * Created by bearg on 5/31/2016.
 */
public class ConnectivityReceiver extends BroadcastReceiver {

    // monitor for changes in network connectivity
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.ic_menu_help)
                .setContentTitle("Connection status changed");

        int notificationId = 1;

        Uri notification = RingtoneManager.getDefaultUri(
                RingtoneManager.TYPE_NOTIFICATION);

        MediaPlayer player = MediaPlayer.create(context, notification);

        boolean networkIsNotAvailable = intent.getBooleanExtra(
                ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

        String availability = networkIsNotAvailable? "No connection":"Network available";
        builder.setContentText(availability);

        player.start();
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationId, builder.build());
    }


}
