package com.example.amritapuriautoserviceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String WHEELS = "";
    private ImageView threeWheels;
    private ImageView fourWheels;
    private ImageView amma;
    private ConstraintLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threeWheels = findViewById(R.id.threeWheel);
        fourWheels = findViewById(R.id.fourWheel);
        amma = findViewById(R.id.amma);
        parent = findViewById(R.id.mainLayout);

        threeWheels.setImageResource(R.drawable.image0);
        fourWheels.setImageResource(R.drawable.image3);
        amma.setImageResource(R.drawable.image1);
        threeWheels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent threeintent = new Intent(MainActivity.this, AutoContact.class);
                threeintent.putExtra(WHEELS, "three");
                startActivity(threeintent);
            }
        });
        fourWheels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fourintent = new Intent(MainActivity.this, AutoContact.class);
                fourintent.putExtra(WHEELS, "four");
                startActivity(fourintent);
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

        return super.onOptionsItemSelected(item);
    }
}
