package com.unflow.sample.java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unflow.androidsdk.ui.opener.OpenerData;

import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment {

    @Nullable
    private ContentViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        this.viewModel = new ViewModelProvider(this).get(ContentViewModel.class);

        View view = inflater.inflate(R.layout.fragment_content, container, false);

        List<OpenerData> openers = new ArrayList<>();
        CustomAdapter adapter = new CustomAdapter(openers);

        // We can also customise the look and feel of opener items and the layout of
        // the openers – here we put them in a vertical list.
        @Nullable RecyclerView recyclerView = view.findViewById(R.id.openerRecyclerView);
        if(recyclerView != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        if (viewModel != null) {
            viewModel.getOpeners().observe(getViewLifecycleOwner(), adapter::setItems);
        }

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}