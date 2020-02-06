package com.example.notificacionbarraestado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button boton;
    int NOTIF_ALERTA_ID = 1;
    NotificationManager nm;
    Notification notificacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.BotonNotificacion);

        Notification.Builder nBuilder = new Notification.Builder(this);
        nBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        nBuilder.setTicker("ALERTA!!");
        nBuilder.setContentTitle("TITULO NOTIFICACION");
        nBuilder.setContentText("Mensaje de relleno");
        nBuilder.setAutoCancel(true);

        Intent i =  new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
        nBuilder.setContentIntent(pi);

        nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificacion=nBuilder.build();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 nm.notify(NOTIF_ALERTA_ID, notificacion);

            }
        });
    }


}
