package com.nandom.doctorsappointment.navfragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.islamkhsh.CardSliderViewPager;
import com.nandom.doctorsappointment.R;
import com.nandom.doctorsappointment.adapters.AvailableTimesAdapter;
import com.nandom.doctorsappointment.adapters.DoctorsAdapter;
import com.nandom.doctorsappointment.models.AvailableTimes;
import com.nandom.doctorsappointment.models.Doctors;

import java.util.ArrayList;
import java.util.List;

import noman.weekcalendar.WeekCalendar;

public class DoctorFragment extends Fragment {

    ImageView ivRightArrow;
    ImageView ivLeftArrow;

    List<AvailableTimes> availableTimesList;
    List<Doctors> doctorsList;

    public DoctorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Indicate that the fragment has menu
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor, container, false);

        availableTimesList = new ArrayList<>();
        doctorsList = new ArrayList<>();

        // add items to arraylist
        populateTimes();
        populateDoctors();

        WeekCalendar weekCalendar = view.findViewById(R.id.weekCalendar);

        ivRightArrow = view.findViewById(R.id.ivRightArrow);
        ivLeftArrow = view.findViewById(R.id.ivLeftArrow);

        ivRightArrow.setOnClickListener(view1 -> weekCalendar.moveToNext());
        ivLeftArrow.setOnClickListener(view1 -> weekCalendar.moveToPrevious());

        CardSliderViewPager cardSliderViewPager = view.findViewById(R.id.viewPager);
        cardSliderViewPager.setAdapter(new AvailableTimesAdapter(availableTimesList, getContext()));

        CardSliderViewPager doctorCardSliderViewPager = view.findViewById(R.id.doctorViewPager);
        doctorCardSliderViewPager.setAdapter(new DoctorsAdapter(doctorsList, getContext()));

        // Inflate the layout for this fragment
        return view;
    }

    private void populateTimes() {

        //Add morning section and times
        List<String> sectionTimes = List.of("06:00am", "06:30am", "07:00am", "07:30am", "08:00am", "08:30am", "10:00am", "11:30am");
        AvailableTimes availableTimes = new AvailableTimes("Morning", "06:00am - 11:30am", R.drawable.ic_sunrise_icon, sectionTimes);
        availableTimesList.add(availableTimes);

        //Add afternoon section and times
        sectionTimes = List.of("12:00pm", "01:00pm", "01:30pm", "04:00pm", "05:30pm");
        availableTimes = new AvailableTimes(getString(R.string.afternoon), "12:00pm - 5:30am", R.drawable.ic_sunny, sectionTimes);
        availableTimesList.add(availableTimes);

        //Add evening section and times
        sectionTimes = List.of("12:00pm", "01:00pm", "01:30pm", "04:00pm", "05:30pm");
        availableTimes = new AvailableTimes("Evening", "06:00pm - 11:30am", R.drawable.ic_moon, sectionTimes);
        availableTimesList.add(availableTimes);

        //Add evening section and times
        sectionTimes = List.of("12:00 am", "`12:30 am", "01:00 am", "01:30 am", "02:00 am", "05:00 am");
        availableTimes = new AvailableTimes("Early", "12:00am - 05:30am", R.drawable.ic_owl, sectionTimes);
        availableTimesList.add(availableTimes);
    }

    private void populateDoctors() {

        //Add Doctors section and times
        Doctors doctors = new Doctors("Dr. Biodun Shiganshina", getString(R.string.general_practitioner), getString(R.string.english), R.drawable.myphoto, getString(R.string.amount));
        doctorsList.add(doctors);

        doctors = new Doctors("Dr. Biodun Shiganshina", getString(R.string.general_practitioner), getString(R.string.english), R.drawable.myphoto, getString(R.string.amount));
        doctorsList.add(doctors);

        doctors = new Doctors("Dr. Biodun Shiganshina", getString(R.string.general_practitioner), getString(R.string.english), R.drawable.myphoto, getString(R.string.amount));
        doctorsList.add(doctors);

        doctors = new Doctors("Dr. Biodun Shiganshina", getString(R.string.general_practitioner), getString(R.string.english), R.drawable.myphoto, getString(R.string.amount));
        doctorsList.add(doctors);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.my_appointment, menu);
        return;
    }
}