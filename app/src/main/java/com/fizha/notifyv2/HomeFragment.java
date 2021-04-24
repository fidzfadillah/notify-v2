package com.fizha.notifyv2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {
    private TextView txtError;
    private LinearLayout error;
    private RecyclerView rvHome;
    private TextView tvName, tvRole;
    private ImageView profileImage;

    //toolbar
    ImageView btnMenu;
    TextView toolbarTitle;

    public static final int TAB_POSITION = 0;

    private Unbinder unbinder;
    private FragmentUpdateCallback fragmentUpdateCallback;
    Context context;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FragmentUpdateCallback) {
            fragmentUpdateCallback = (FragmentUpdateCallback)context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        unbinder = ButterKnife.bind(this, v);
        context = getContext();//get current user

        //toolbar
        toolbarTitle = v.findViewById(R.id.toolbar_title);
        btnMenu = v.findViewById(R.id.toolbar_nav_icon);
        toolbarTitle.setText("");

        profileImage = v.findViewById(R.id.profile_image);
        rvHome = v.findViewById(R.id.recycler_buat_kamu);
        tvName = v.findViewById(R.id.name);
        tvRole = v.findViewById(R.id.as);

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (unbinder != null){
            unbinder.unbind();
        }
    }
}