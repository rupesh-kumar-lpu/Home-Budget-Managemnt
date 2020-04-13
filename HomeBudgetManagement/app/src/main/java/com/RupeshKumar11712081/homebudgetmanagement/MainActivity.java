package com.RupeshKumar11712081.homebudgetmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         sharedPreferences= getSharedPreferences("MySharedPref", MODE_PRIVATE);
         sh= getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
         if(!(Integer.toString((sh.getInt("budget", 0)))).equals("0")){
             Intent intent=new Intent(MainActivity.this,HomeBudgetActivity.class);
             startActivity(intent);
             finish();
         }
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText usernameEditText = (EditText) findViewById(R.id.editText);
                String Val = usernameEditText.getText().toString();
                if (Val.matches("")) {
                    Toast.makeText(MainActivity.this, "Enter some value please!", Toast.LENGTH_SHORT).show();

                } else {
                    // Creating an Editor object
// to edit(write to the file)
                    SharedPreferences.Editor myEdit
                            = sharedPreferences.edit();

// Storing the key and its value
// as the data fetched from edittext

                    myEdit.putInt("budget", Integer.parseInt(((EditText) findViewById(R.id.editText)).getText().toString()));

// Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
                    myEdit.commit();
                    Intent intent = new Intent(MainActivity.this, HomeBudgetActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });



    }
}
