package com.jamillabltd.curvedbottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.jamillabltd.curvedbottomnavigationbar.fragments.HomeFragment;
import com.jamillabltd.curvedbottomnavigationbar.fragments.MessageFragment;
import com.jamillabltd.curvedbottomnavigationbar.fragments.ProfileFragment;
import com.jamillabltd.curvedbottomnavigationbar.fragments.SettingFragment;

public class MainActivity extends AppCompatActivity {
    private int selectedItemId = 1; // Default selected item ID is 1 (home)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set home as the default fragment
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_id, HomeFragment.class, null)
                .commit();

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.show(1, true); // Select home icon by default

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_message_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_person_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.baseline_settings_24));

        bottomNavigation.setOnClickMenuListener(model -> {
            selectedItemId = model.getId();

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

    @Override
    public void onBackPressed() {
        if (selectedItemId == 1) {
            // If the current selected item is home, perform the default back button action
            super.onBackPressed();
            this.finish();
        } else {
            // If the current selected item is not home, set the home item as selected
            MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
            bottomNavigation.show(1, true);
            selectedItemId = 1;
        }
    }
}