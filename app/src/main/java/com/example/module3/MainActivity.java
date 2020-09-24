package com.example.module3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText userName, Password;
    Button submit;

    private void init() {
        userName = (EditText) findViewById(R.id.userName);
        Password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        notificationChannel();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        String uName = userName.getText().toString();
        String password = Password.getText().toString();
        outState.putString("UserName",uName);
        outState.putString("PassworHere",password);
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

        String uName = savedInstanceState.getString("UserName");
        String password = savedInstanceState.getString("PasswordHere");
        userName.setText(uName);
        Password.setText(password);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onClick(View view) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "notification");
            String username, password;
            username = "edureka";
            password = "edureka123";

            if (username.equals(userName.getText().toString()) && password.equals(Password.getText().toString())) {

                builder.setContentTitle("SUCCESS");
                builder.setContentText("You are login successfully");
                builder.setSmallIcon(R.drawable.smiley);
                Notification notification = builder.build();

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                notificationManager.notify(101, notification);

            } else {


                builder.setContentTitle("Login Failed");
                builder.setContentText("Your login id and password is wrong");
                builder.setSmallIcon(R.drawable.sadface);
                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(101, notification);

            }
        Intent intent = new Intent(this,activityTwo.class);
            startActivity(intent);
        }

        private void notificationChannel(){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("notification", "notifi", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }

        }

 }


