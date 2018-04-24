package com.example.thinkcreator.praticalquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    EditText ed_name,ed_email,ed_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (savedInstanceState!=null){
            ed_name.setText(getBundleData(savedInstanceState,"username"));
            ed_email.setText(getBundleData(savedInstanceState,"email"));
            ed_message.setText(getBundleData(savedInstanceState,"yourself"));
        }

    }

    private void init() {
        ed_name=(EditText) findViewById(R.id.ed_name);
        ed_email=(EditText) findViewById(R.id.ed_email);
        ed_message=(EditText) findViewById(R.id.ed_message);
        sharedPreferences = getSharedPreferences("info",MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("username", ed_name.getText().toString());
        outState.putString("email", ed_email.getText().toString());
        outState.putString("message", ed_message.getText().toString());
    }
    public void nextmethod(View view) {

        Intent il=new Intent(this,DetailActivity.class);
        il.putExtra("name",ed_name.getText().toString());
        il.putExtra("email",ed_email.getText().toString());
        il.putExtra("message",ed_message.getText().toString());
        startActivity(il);

        ed_name.setText("");
        ed_email.setText("");
        ed_message.setText("");
    }

    private String getBundleData(Bundle bundle, String key){
        return bundle.getString(key,"");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_main_setting) {
            Intent openActivity = new Intent(this, DetailActivity.class);
            startActivity(openActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
