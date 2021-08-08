package com.mutinda.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.mutinda.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private String mOrderMessage;
    public static final String extraOrderKey = "MY KEY ORDER MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(extraOrderKey,mOrderMessage);
                startActivity(intent);
            }
        });
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
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (id) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
                break;
            case R.id.action_call:
                Uri callUri = Uri.parse("tel:0700671519");
                Intent intent1 = new Intent(Intent.ACTION_DIAL, callUri);
                startActivity(intent1);
                break;
            case R.id.action_status:
                displayToast("Status: okay");
                break;
            case R.id.action_location:
                //Open Google map showing current device location
                break;
            case R.id.action_about_us:
                Uri webUri = Uri.parse("https://creambell.com/about/");
                Intent intent2 = new Intent(Intent.ACTION_VIEW,webUri);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public  void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void showDonut(View view) {
        mOrderMessage = String.valueOf(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void showIceCreamSandwich(View view){
        mOrderMessage = String.valueOf(R.string.ice_cream_sandwich_order);
        displayToast(mOrderMessage);
    }

    public void showFroyo(View view){
        mOrderMessage = String.valueOf(R.string.froyo_order);
        displayToast(mOrderMessage);
    }
}