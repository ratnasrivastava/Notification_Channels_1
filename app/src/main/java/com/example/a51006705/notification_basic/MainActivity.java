package com.example.a51006705.notification_basic;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.a51006705.notification_basic.App.CHANNEL_1_ID;
import static com.example.a51006705.notification_basic.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextTitle;
    private EditText mEditTextMessage;
    private Button mButtonSendOnChannel1;
    private Button mButtonSendOnChannel2;
    private NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextTitle = findViewById(R.id.edit_text_title);
        mEditTextMessage = findViewById(R.id.edit_text_message);

        mButtonSendOnChannel1 = findViewById(R.id.button_send_on_channel1);
        mButtonSendOnChannel2 = findViewById(R.id.button_send_on_channel2);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        mButtonSendOnChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotificationOnChannel1(v);
            }
        });

        mButtonSendOnChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotificationOnChannel2(v);
            }
        });
    }


    private void sendNotificationOnChannel1(View v) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentTitle(mEditTextTitle.getText().toString())
                .setContentText(mEditTextMessage.getText().toString())
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    private void sendNotificationOnChannel2(View v) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentTitle(mEditTextTitle.getText().toString())
                .setContentText(mEditTextMessage.getText().toString())
                .build();

        notificationManagerCompat.notify(2, notification);
    }


}
