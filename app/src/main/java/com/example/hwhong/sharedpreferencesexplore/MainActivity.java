package com.example.hwhong.sharedpreferencesexplore;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView foodTV;
    EditText foodET;
    TextView display;
    Button button;
    final static String My_PREFERENCES= "sharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodTV = (TextView) findViewById(R.id.foodTV);
        foodET = (EditText) findViewById(R.id.foodET);
        display = (TextView) findViewById(R.id.displayText);

        //when sharedpreferences is initialized here
        // edit.putString("foodname", foodET.getText().toString()); is in your onCreate() which
        // saves the value of edittext (which is empty during oncreate) in shared preference once
        // during creation of your activity. Now you have moved the code inside the button onclick
        // the value of edit text is stored inside share preference every time you click the button
        // and fetched back within onclick

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences(My_PREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.putString("foodname", foodET.getText().toString());
                edit.commit();


                SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences(My_PREFERENCES, Context.MODE_PRIVATE);
                String food = sharedPreferences1.getString("foodname", "");
                display.setText(food);
            }
        });
    }
}
