package com.alaminkarno.meowbottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;


public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    private final static int HOME_ID = 1;
    private final static int CART_ID = 2;
    private final static int FAV_ID = 3;
    private final static int ACCOUNT_ID = 4;

    private boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.show(HOME_ID,true);

        bottomNavigation.add(new MeowBottomNavigation.Model(HOME_ID,R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(CART_ID,R.drawable.ic_baseline_shopping_cart_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(FAV_ID,R.drawable.ic_baseline_favorite_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ACCOUNT_ID,R.drawable.ic_baseline_people_24));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                switch (item.getId()){
                    case HOME_ID:
                        isSelected = false;
                        break;

                    case CART_ID:
                    case FAV_ID:
                    case ACCOUNT_ID:
                        isSelected = true;
                        break;
                }
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                switch (item.getId()){
                    case HOME_ID:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case CART_ID:
                        Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case FAV_ID:
                        Toast.makeText(MainActivity.this, "FAV", Toast.LENGTH_SHORT).show();
                        break;
                    case ACCOUNT_ID:
                        Toast.makeText(MainActivity.this, "ACCOUNT", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                // your codes
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(isSelected){

            bottomNavigation.show(HOME_ID,true);
            isSelected = false;
        }
        else {
            super.onBackPressed();
        }

    }
}