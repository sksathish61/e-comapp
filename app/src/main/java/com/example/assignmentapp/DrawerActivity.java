package com.example.assignmentapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.FrameLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private FrameLayout frameLayout;
    private static  final int HOME_FRAGMENT = 0;
    private static  final int CART_FRAGMENT = 1;

    private  static int currrentFragment;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);


        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();


        frameLayout = findViewById(R.id.main_framelayout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (currrentFragment == HOME_FRAGMENT) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.drawer, menu);
        }

            return true;

    }


    public boolean onOptionsItemselected(MenuItem item)
    {

        int id = item.getItemId();

        if(id == R.id.main_search_icon)
        {
            return true;
        }else if (id == R.id.main_notification_icon)
        {
            return true;
        }else if (id == R.id.main_cart_icon)
        {


            myCart();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void myCart() {
        invalidateOptionsMenu();
        setFragment(new fragment_mycart(),CART_FRAGMENT);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    private void setFragment(Fragment fragment, int fragmentNo)
    {
        currrentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }





}
