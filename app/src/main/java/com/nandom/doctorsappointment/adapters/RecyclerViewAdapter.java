package com.nandom.doctorsappointment.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nandom.doctorsappointment.MainActivity;
import com.nandom.doctorsappointment.R;
import com.nandom.doctorsappointment.models.ServiceModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private List<ServiceModel> brandsList;
    private Context mContext;

    public RecyclerViewAdapter(Context context, List<ServiceModel> brandsList) {
        this.brandsList = brandsList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        final ServiceModel brand = brandsList.get(position);

        Glide.with(mContext)
                .asBitmap()
                .load(brand.getThumbnail())
                .into(holder.image);

        holder.serviceCard.setCardBackgroundColor((position % 2 == 0 ? Color.parseColor("#8DE7F7") : Color.parseColor("#FDBDC3")));

        holder.name.setText(brand.getServiceName());

        holder.image.setOnClickListener(view -> {

            Toast.makeText(mContext, brand.getServiceName(), Toast.LENGTH_SHORT).show();

        });
    }

    @Override
    public int getItemCount() {
        return brandsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        CardView serviceCard;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);
            serviceCard = itemView.findViewById(R.id.serviceCard);
        }
    }
}
