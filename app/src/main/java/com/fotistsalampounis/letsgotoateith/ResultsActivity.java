package com.fotistsalampounis.letsgotoateith;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import com.example.user.letsgotoateith.R;


public class ResultsActivity extends ActionBarActivity implements ResultsFragment.Callback{

    private BroadcastReceiver brRe=new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Log.d("onReceive", "Logout in progress");
            //At this point you should start the login activity and finish this one
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ResultsFragment())
                    .commit();
        }

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.package.ACTION_LOGOUT");
        registerReceiver(brRe, intentFilter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onItemSelected(String text) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(brRe);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        Log.v("User ID", "User ID: " + getString(R.string.pref_id_key));
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_logout) {
//            SharedPreferences prefs=getApplication().getSharedPreferences("session", Context.MODE_PRIVATE);
//            //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplication());
//            prefs.edit().putInt(getString(R.string.pref_id_key),-1);
//            prefs.edit().putString(getString(R.string.pref_username_key),"-1");
//            prefs.edit().commit();
//            finish();
//        }
//        Log.v("User ID", "User ID: "+getString(R.string.pref_id_key));
//        return super.onOptionsItemSelected(item);
//    }

}
