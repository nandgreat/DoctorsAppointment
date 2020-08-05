package com.nandom.doctorsappointment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nandom.doctorsappointment.adapters.RecyclerViewAdapter;
import com.nandom.doctorsappointment.models.ServiceModel;
import com.nandom.doctorsappointment.navfragments.AppointmentFragment;
import com.nandom.doctorsappointment.navfragments.DoctorFragment;
import com.nandom.doctorsappointment.navfragments.HomeFragment;
import com.nandom.doctorsappointment.navfragments.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.nav_doctors:
                    loadFragment(new DoctorFragment());
                    break;
                case R.id.nav_appointments:
                    loadFragment(new AppointmentFragment());
                    break;
                case R.id.nav_profile:
                    loadFragment(new ProfileFragment());
                    break;

                case R.id.nav_home:
                default:
                    loadFragment(new HomeFragment());
            }
            return true;
        });
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}