package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
public Toolbar toolbar;
public DrawerLayout drawerLayout;

public NavController navcontroller;
    public NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigation();
    }
    public void setupNavigation(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    drawerLayout= findViewById(R.id.drawer_layout);
    navigationView= findViewById(R.id.navigation_view);
    navcontroller = Navigation.findNavController(this,R.id.host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navcontroller,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navcontroller);
        navigationView.setNavigationItemSelectedListener(this);


    }
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }
    public boolean onSupportNavigateUp(){
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.host_fragment),drawerLayout);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       menuItem.setCheckable(true);
       drawerLayout.closeDrawers();
       int id=menuItem.getItemId();
       switch (id)
       {

           case R.id.first:
               Toast.makeText(getApplicationContext(),"First clicked",Toast.LENGTH_LONG).show();
               navcontroller.navigate(R.id.first);
               break;
           case R.id.second:
               Toast.makeText(getApplicationContext(),"second clicked",Toast.LENGTH_LONG).show();
               navcontroller.navigate(R.id.second);
               break;
           case R.id.third:
               Toast.makeText(getApplicationContext(),"Third clicked",Toast.LENGTH_LONG).show();
               navcontroller.navigate(R.id.third);
               break;
       }



        return true;
    }
}
