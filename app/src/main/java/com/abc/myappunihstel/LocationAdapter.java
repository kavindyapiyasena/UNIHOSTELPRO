package com.abc.myappunihstel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private final List<LocationInfo> locationList;
    private final Context context;

    public LocationAdapter(List<LocationInfo> locationList, Context context) {
        this.locationList = locationList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.location_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LocationInfo location = locationList.get(position);
        holder.name.setText(location.getName());
        holder.status.setText(location.getStatus());
        holder.closingTime.setText("Closes: " + location.getClosingTime());
        holder.phone.setText("T.P: " + location.getPhone());
        holder.description.setText(location.getAddress());

        // ✅ Show directions using fixed accurate coordinates
        holder.btnDirection.setOnClickListener(v -> {
            String label = Uri.encode("Open University Colombo Regional Center");
            String uriString = "geo:0,0?q=6.883191270523492,79.88660636773835(" + label + ")";
            Uri gmmIntentUri = Uri.parse(uriString);

            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(mapIntent);
            } else {
                Toast.makeText(context, "Google Maps app is not installed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, status, closingTime, phone, description;
        Button btnDirection;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.locationName);
            status = itemView.findViewById(R.id.locationStatus);
            closingTime = itemView.findViewById(R.id.locationClosingTime);
            phone = itemView.findViewById(R.id.locationPhone);
            description = itemView.findViewById(R.id.locationDescription);
            btnDirection = itemView.findViewById(R.id.btnDirection);
        }
    }
}
