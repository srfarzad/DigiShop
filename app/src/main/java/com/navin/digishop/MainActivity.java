package com.navin.digishop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.navin.digishop.ui.main.CategoryFragment;
import com.navin.digishop.ui.main.HomeFragment;
import com.navin.digishop.ui.main.ProfileFragment;
import com.navin.digishop.ui.main.adapter.TabsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bottom_navigation) BottomNavigationView bottom_navigation;

    @BindView(R.id.pager) ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();



        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {


                    case R.id.item_home :


                        pager.setCurrentItem(0);

                        bottom_navigation.getMenu().getItem(0).setChecked(true);


                    //    getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();




                        break;

                    case R.id.item_category :

                        bottom_navigation.getMenu().getItem(1).setChecked(true);
                        pager.setCurrentItem(1);


                // getSupportFragmentManager().beginTransaction().replace(R.id.frame,new CategoryFragment()).commit();



                        break;


                    case R.id.item_profile :
                        bottom_navigation.getMenu().getItem(2).setChecked(true);
                        pager.setCurrentItem(2);


              //   getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ProfileFragment()).commit();



                        break;





                }


                return false;
            }
        });


        TabsAdapter adapter =new TabsAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);


    }
}
