package com.nandom.doctorsappointment.navfragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nandom.doctorsappointment.R;
import com.nandom.doctorsappointment.adapters.RecyclerViewAdapter;
import com.nandom.doctorsappointment.data.User;
import com.nandom.doctorsappointment.models.ServiceModel;
import com.nandom.doctorsappointment.util.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private List<ServiceModel> serviceModelList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        serviceModelList = new ArrayList<>();

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        SharedPrefManager sharedPrefManager = new SharedPrefManager(getContext());

        User meUser = sharedPrefManager.getLoggedInUser();

        toolbar.setTitle("Hi, ".concat(meUser.getFirstName()));

        populateServiceModel();

        initRecyclerView(view);
        // Inflate the layout for this fragment
        return view;
    }

    private void populateServiceModel() {

        ServiceModel serviceModel = new ServiceModel(R.drawable.ic_calendar_two, "Book an appointment");
        serviceModelList.add(serviceModel);
        serviceModel = new ServiceModel(R.drawable.ic_checkup, "Order medication");
        serviceModelList.add(serviceModel);
        serviceModel = new ServiceModel(R.drawable.ic_microscope, "Book a diagnostic test");
        serviceModelList.add(serviceModel);
    }


    private void initRecyclerView(View view) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewServices = view.findViewById(R.id.recyclerViewServices);
        recyclerViewServices.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), serviceModelList);
        recyclerViewServices.setAdapter(adapter);
    }
}