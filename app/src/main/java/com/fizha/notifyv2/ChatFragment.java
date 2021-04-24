package com.fizha.notifyv2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ChatFragment extends Fragment {
    private ImageView btnMenu;
    private TextView toolbarTitle;
    LinearLayout toolbar;

    public static final int TAB_POSITION = 2;

    private Unbinder unbinder;
    private FragmentUpdateCallback fragmentUpdateCallback;

    public ChatFragment() {
        // Required empty public constructor
    }

    public static ChatFragment newInstance(){
        return new ChatFragment();
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
        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        unbinder = ButterKnife.bind(this, v);

        //toolbar
        toolbar = v.findViewById(R.id.toolbar);
        toolbarTitle = v.findViewById(R.id.toolbar_title);
        btnMenu = v.findViewById(R.id.toolbar_nav_icon);
        toolbarTitle.setText("Chat");
        toolbar.setBackgroundColor(0xFFFFFFFF);

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