package com.mutinda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    String displayMessage;
    TextView orderDisplay;
    boolean checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderDisplay = findViewById(R.id.display_order);

        Intent  intent = getIntent();
        displayMessage = intent.getStringExtra(MainActivity.extraOrderKey);
        orderDisplay.setText(displayMessage);
    }

    public void onRadioButtonClicked(View view) {
        checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.same_day:
                if(checked){
                    displayToast(getString(R.string.same_day));
                }
                break;
            case R.id.next_day:
                displayToast(getString(R.string.next_day));
                break;
            case R.id.pick_up:
                displayToast(getString(R.string.pick_up));
                break;
            default:
                //do something
                break;
        }
    }

    public  void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}