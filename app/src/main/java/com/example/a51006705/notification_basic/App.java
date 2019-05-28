package com.example.a51006705.notification_basic;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/**
 * Created by 51006705 on 28-05-2019.
 */

public class App extends Application {
    public static final String CHANNEL_1_ID = "Channel1";
    public static final String  CHANNEL_2_ID = "Channel2";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        //below apk level 26 it doesn't work

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel1",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationChannel1.setDescription("This is Channel 1");

            NotificationChannel notificationChannel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel2",
                    NotificationManager.IMPORTANCE_LOW);
            notificationChannel2.setDescription("This is Channel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel1);
            manager.createNotificationChannel(notificationChannel2);
        }
    }
}
