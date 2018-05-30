package org.esiea.varatharajah_azizi.azcode;


import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //******TOOLBAR*********
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        setSupportActionBar ((Toolbar) findViewById (R.id.my_toolbar));

        //******PARTIE CORPS*******
        Button btn_code = findViewById (R.id.btn_code);

        btn_code.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, CodeActivity.class);
               startActivity (intent);

            }});


        Button btn_site=findViewById(R.id.btn_site);
        btn_site.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View view){

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.azyou.fr/"));
        startActivity(intent);
        }
        });
        }

//***************PARTIE Toolbar***************
public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
        }

@Override
public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
        case R.id.exit:
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.exit)
        .setMessage(R.string.msg_exit)
        .setPositiveButton(R.string.yes,new DialogInterface.OnClickListener(){
@Override
public void onClick(DialogInterface dialog,int id){
        Toast.makeText(getApplicationContext(),R.string.Goodbye,Toast.LENGTH_SHORT).show();
        finish();
        }
        })
        .setNegativeButton(R.string.no,new DialogInterface.OnClickListener(){
@Override
public void onClick(DialogInterface dialog,int id){
        Toast.makeText(getApplicationContext(),R.string.cancel,Toast.LENGTH_SHORT).show();
        }
        });
        builder.create().show();
        return true;

        case R.id.about:

        Context context=getApplicationContext();
        CharSequence text=context.getString(R.string.msg_about);
        int duration=Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(context,text,duration);
        //Toast toast = Toast.makeText(context, context.getString(R.string.cancel), Toast.LENGTH_LONG).show();
        toast.show();
              return true;

        case R.id.FAQ:
        Intent intent2=new Intent(Intent.ACTION_VIEW);
        intent2.setData(Uri.parse("https://www.azyou.fr/pages/faq"));
        startActivity(intent2);
        return true;

default:
        // If we got here, the user's action was not recognized.
        // Invoke the superclass to handle it.
        return super.onOptionsItemSelected(item);
        }
        }
        }