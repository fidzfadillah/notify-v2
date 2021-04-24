package com.fizha.notifyv2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fizha.notifyv2.adapter.MainFragmentPagerAdapter;

public class DetailPostFragment extends Fragment {
    private ImageView btnBack;
    private TextView toolbarTitle;

    private FragmentManager fragmentManager;
    private MainFragmentPagerAdapter mainFragmentPagerAdapter;

    static Fragment newInstance() {
        return new DetailPostFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_post, container, false);

        btnBack = v.findViewById(R.id.toolbar_nav_icon);
        toolbarTitle = v.findViewById(R.id.toolbar_title);

        btnBack.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        toolbarTitle.setText("");

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}