package com.baoyachi.slidelockview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_viewdraghelper01:
                startActivity(new Intent(this,ViewDragHelper01Activity.class));
                break;
            case R.id.action_viewdraghelper02:
                startActivity(new Intent(this,ViewDragHelper02Activity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
