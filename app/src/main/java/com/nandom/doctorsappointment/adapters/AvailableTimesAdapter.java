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
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.nandom.doctorsappointment.R;
import com.nandom.doctorsappointment.models.AvailableTimes;

import java.util.List;

public class AvailableTimesAdapter extends CardSliderAdapter<AvailableTimesAdapter.AvailableTimesViewHolder> {

    private List<AvailableTimes> times;
    private Context context;

    public AvailableTimesAdapter(List<AvailableTimes> times, Context context) {
        this.times = times;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return times.size();
    }

    @NonNull
    @Override
    public AvailableTimesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_times_item, parent, false);
        return new AvailableTimesViewHolder(view);
    }


    @Override
    public void bindVH(AvailableTimesViewHolder availableTimesViewHolder, int position) {

        AvailableTimes availableTimes = times.get(position);

        Glide.with(context).load(availableTimes.getTimeImage()).into(availableTimesViewHolder.ivTimeIcon);
        availableTimesViewHolder.tvTimeTitle.setText(availableTimes.getTimeTitle());
        availableTimesViewHolder.tvSectionTime.setText(availableTimes.getTimeInterval());

        for (String time : availableTimes.getMyAvailableTimes()) {
            Chip chip = new Chip(context, null, R.style.CustomChipChoiceStyle);
            chip.setText(time);
            chip.setTextSize(12f);

            // necessary to get single selection working
            chip.setClickable(true);
            chip.setCheckable(true);
            availableTimesViewHolder.chipGroup.addView(chip);
        }

    }

    public static class AvailableTimesViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivTimeIcon;
        private TextView tvTimeTitle;
        private TextView tvSectionTime;
        private ChipGroup chipGroup;

        public AvailableTimesViewHolder(View view) {
            super(view);

            ivTimeIcon = view.findViewById(R.id.ivTimeIcon);
            tvTimeTitle = view.findViewById(R.id.tvTimeTitle);
            tvSectionTime = view.findViewById(R.id.tvSectionTime);
            chipGroup = view.findViewById(R.id.chipGroup);
        }
    }
}