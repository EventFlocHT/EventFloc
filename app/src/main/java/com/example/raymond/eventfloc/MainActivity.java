package com.example.raymond.eventfloc;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

 public static void main (String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
 EventType a = new EventType(4563, "Party");
 EventType b = new EventType(4652, "Free Food");

 String party = "Event ID " + a.getEventTypeID() + " is a " + a.getEventType();
 String freeFood = "Event ID " + b.getEventTypeID() + " is a " + b.getEventType();

 System.out.println(party);
 System.out.println(freeFood);

     Student s = new Student("s@google.com", "hello", 76543, "Bob", "Bob");


     System.out.println(s.toString());

     Student d= new Student("bob@gmail.com", "oijasd", 12345, "James", "James");
     System.out.println(d.toString());
 }
}
