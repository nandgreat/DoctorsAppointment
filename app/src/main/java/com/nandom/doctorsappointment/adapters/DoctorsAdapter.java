package com.nandom.doctorsappointment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.islamkhsh.CardSliderAdapter;
import com.nandom.doctorsappointment.R;
import com.nandom.doctorsappointment.models.Doctors;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorsAdapter extends CardSliderAdapter<DoctorsAdapter.DoctorsViewHolder> {

    private List<Doctors> times;
    private Context context;

    public DoctorsAdapter(List<Doctors> times, Context context) {
        this.times = times;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return times.size();
    }

    @NonNull
    @Override
    public DoctorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_item, parent, false);
        return new DoctorsViewHolder(view);
    }


    @Override
    public void bindVH(DoctorsViewHolder doctorsViewHolder, int position) {

        Doctors doctor = times.get(position);
        Glide.with(context).load(doctor.getDoctorImage()).into(doctorsViewHolder.ivDoctorImage);
        doctorsViewHolder.ivDoctorName.setText(doctor.getDoctorName());
        doctorsViewHolder.tvSpecialty.setText(doctor.getSpecialty());
        doctorsViewHolder.tvLanguage.setText(doctor.getLanguage());
    }

    public static class DoctorsViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView ivDoctorImage;
        private TextView ivDoctorName;
        private TextView tvSpecialty;
        private TextView tvLanguage;

        public DoctorsViewHolder(View view) {
            super(view);

            ivDoctorImage = view.findViewById(R.id.ivDoctorImage);
            ivDoctorName = view.findViewById(R.id.ivDoctorName);
            tvSpecialty = view.findViewById(R.id.tvSpecialty);
            tvLanguage = view.findViewById(R.id.tvLanguage);
        }
    }
}