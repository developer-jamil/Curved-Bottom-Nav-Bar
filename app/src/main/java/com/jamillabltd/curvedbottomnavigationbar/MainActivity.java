package com.jamillabltd.curvedbottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.jamillabltd.curvedbottomnavigationbar.fragments.HomeFragment;
import com.jamillabltd.curvedbottomnavigationbar.fragments.MessageFragment;
import com.jamillabltd.curvedbottomnavigationbar.fragments.ProfileFragment;
import com.jamillabltd.curvedbottomnavigationbar.fragments.SettingFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set home as a default fragment
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_id, HomeFragment.class, null)
                .commit();

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.show(1, true); //home icon selected

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_message_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_person_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.baseline_settings_24));


        bottomNavigation.setOnClickMenuListener(model -> {
            // YOUR CODES
            switch (model.getId()) {
                case 1:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, HomeFragment.class, null)
                            .commit();
                    break;
                case 2:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, MessageFragment.class, null)
                            .commit();
                    break;
                case 3:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, ProfileFragment.class, null)
                            .commit();
                    break;
                case 4:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, SettingFragment.class, null)
                            .commit();
                    break;
            }


            return null;
        });

    }
}


   /* bottomNavigation.setOnShowListener(model -> {
            if (model.getId() == 1) {
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            }else if (model.getId() == 2){
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            }else if (model.getId() == 3){
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
            }else if (model.getId() == 4){
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
            }
            return null;
        });*/
