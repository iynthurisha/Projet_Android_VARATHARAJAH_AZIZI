package org.esiea.varatharajah_azizi.azcode;

import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Younes on 22/05/2018.
 */


public class CodeActivity extends AppCompatActivity {
    int[] IMAGES = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6,};
    String[] PROMO = {"MOINS 5%", "MOINS 10%", "MOINS 15%", "MOINS 20%", "LIVRAISON OFFERTE", "MOINS 25%"};
    String[] DESCRIPTION = {"Réduction à partir de 20 euros d'achats", "Réduction sur la collection Beauté&Bien-être", "Réduction à partir de 50 euros d'achats", "Réduction à partir de 70 euros d'achats",
            "Livraison OFFERTE sur votre 1ère commande", "Réduction à partir de 100 euros d'achats"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_code);

        //------------------Notification----------//
        NotificationCompat.Builder nbuilder = new NotificationCompat.Builder (this);
        nbuilder.setSmallIcon (R.drawable.bell);
        nbuilder.setContentTitle ("AZCODE");
        Context context = getApplicationContext ();
        CharSequence text = context.getString (R.string.notif_msg);
        nbuilder.setContentText (text);
        Notification notification = nbuilder.build ();
        NotificationManagerCompat.from (this).notify (0, notification);


        ListView listView = (ListView) findViewById (R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter ();
        listView.setAdapter (customAdapter);


        //--------------
        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] PROMO = {"MOINS 5%", "MOINS 10%", "MOINS 15%", "MOINS 20%", "LIVRAISON OFFERTE", "MOINS 25%"};


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder (CodeActivity.this);

                // set title
                alertDialogBuilder.setTitle (R.string.title_promo);

                if (PROMO[position].equals ("MOINS 5%")) {
                    alertDialogBuilder.setMessage ("A05P18Z");
                }

                if (PROMO[position].equals ("MOINS 10%")) {
                    alertDialogBuilder.setMessage ("A10P18Z");
                }

                if (PROMO[position].equals ("MOINS 15%")) {
                    alertDialogBuilder.setMessage ("A15P18Z");
                }

                if (PROMO[position].equals ("MOINS 20%")) {
                    alertDialogBuilder.setMessage ("A20P18Z");
                }

                if (PROMO[position].equals ("MOINS 25%")) {
                    alertDialogBuilder.setMessage ("A25P18Z");
                }

                if (PROMO[position].equals ("LIVRAISON OFFERTE")) {
                    alertDialogBuilder.setMessage ("FREESHI18");
                }

                alertDialogBuilder.setPositiveButton ("Ok", new DialogInterface.OnClickListener () {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create ();

                // show it
                alertDialog.show ();
            }
        });
    }


    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater ().inflate (R.layout.customlayout, null);

            ImageView imageView = (ImageView) view.findViewById (R.id.imageView);
            TextView textView_promo = (TextView) view.findViewById (R.id.textView_promo);
            TextView textView_description = (TextView) view.findViewById (R.id.textView_description);

            imageView.setImageResource (IMAGES[i]);
            textView_promo.setText (PROMO[i]);
            textView_description.setText (DESCRIPTION[i]);

            return view;
        }
    }
}