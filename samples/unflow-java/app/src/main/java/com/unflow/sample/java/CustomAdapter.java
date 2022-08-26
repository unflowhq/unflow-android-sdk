package com.unflow.sample.java;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.unflow.androidsdk.UnflowSdk;
import com.unflow.androidsdk.ui.opener.OpenerData;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<OpenerData> openers;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public @Nullable Long screenId;

        public ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.customOpenerItemImage);
            textView = view.findViewById(R.id.customOpenerItemText);

            view.setOnClickListener(v -> {
                if(screenId != null) {
                    UnflowSdk.Companion.client().openScreen(screenId);
                }
            });
        }

        public void setScreenId(Long screenId) {
            this.screenId = screenId;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet OpenerData[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(List<OpenerData> dataSet) {
        openers = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_custom_opener, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        OpenerData opener = openers.get(position);
        viewHolder.textView.setText(opener.getTitle());
        viewHolder.setScreenId(opener.getScreenId());
        Glide.with(viewHolder.imageView).load(opener.getImageUrl()).into(viewHolder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return openers.size();
    }

    // Naive implementation for sample purposes only – you should do something smarter.
    // e.g. Using ListAdapter with item diffing.
    @SuppressLint("NotifyDataSetChanged")
    public void setItems(List<OpenerData> openers) {
        this.openers = openers;
        notifyDataSetChanged();
    }
}
