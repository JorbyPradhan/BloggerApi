package com.example.jb.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.jb.myapplication.Fragment.NetworkInfrastructure;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by jb on 26/11/2018.
 */

public class MessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        showNotification(remoteMessage.getNotification().getBody());
    }
    public void showNotification(String message){
        PendingIntent pi= PendingIntent.getActivity(this,0,new Intent(this, NetworkInfrastructure.class),0);
        Notification notification= new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_local_library_24dp)
                .setContentTitle("Network")
                .setContentText(message)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}
