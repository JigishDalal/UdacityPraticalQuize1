package com.example.thinkcreator.praticalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {
    String name,email,message;
    TextView tvName,tvEmail, tvMessage;
    TextView about,detaisl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Detail Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
       getdata();
    }

    private void getdata() {
        Bundle il =getIntent().getExtras();
        if(il!=null) {
            name = il.getString("name");
            email = il.getString("email");
            message = il.getString("message");
        }
        tvName=(TextView)findViewById(R.id.tv_name);
        tvEmail=(TextView)findViewById(R.id.tv_email);
        tvMessage=(TextView)findViewById(R.id.tv_message);
        about=(TextView)findViewById(R.id.tv_about);
        detaisl=(TextView)findViewById(R.id.tv_details);

        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
        tvName.setText(name);
        tvEmail.setText(email);
        tvMessage.setText(message);
        about.setText("ABOUT US");
        detaisl.setText("The class String includes methods for examining individual characters of the sequence, for comparing strings, for searching strings, for extracting substrings, and for creating a copy of a string with all characters translated to uppercase or to lowercase.");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent il= new Intent(this,MainActivity.class);
            startActivity(il);
        }
        return super.onOptionsItemSelected(item);
    }
}
