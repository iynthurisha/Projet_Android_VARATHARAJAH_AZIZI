package org.esiea.varatharajah_azizi.azcode;

import android.app.Notification;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Iys on 17/05/2018.
 */

public class CodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_code);


        NotificationCompat.Builder builder = new NotificationCompat.Builder (this);
        builder.setSmallIcon (R.drawable.bell);
        builder.setContentTitle ("AZYOU");
        String text ="Bienvenue dans AZCODE n'hésite pas a visiter le siteweb AZ YOU et utiliser vos codes !!!" +
                "Bon Shopping";
        builder.setContentText (text);
        Notification notification = builder.build ();
        NotificationManagerCompat.from (this).notify (0, notification);
    }
}
