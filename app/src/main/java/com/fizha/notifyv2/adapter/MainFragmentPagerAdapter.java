package com.fizha.notifyv2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fizha.notifyv2.AkunFragment;
import com.fizha.notifyv2.ChatFragment;
import com.fizha.notifyv2.ForumFragment;
import com.fizha.notifyv2.HomeFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final List<Fragment> BASE_FRAGMENTS = Arrays.asList(
            HomeFragment.newInstance(),
            ForumFragment.newInstance(),
            ChatFragment.newInstance(),
            AkunFragment.newInstance()
    );

    private static final int HOME_POSITION = 0;
    private static final int FORUM_POSITION = 1;
    private static final int CHAT_POSITION = 2;
    private static final int AKUN_POSITION = 3;

    private List<Fragment> mHomeFragments;
    private List<Fragment> mForumFragments;
    private List<Fragment> mChatFragments;
    private List<Fragment> mAkunFragments;

    public MainFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

        mHomeFragments = new ArrayList<>();
        mForumFragments = new ArrayList<>();
        mChatFragments = new ArrayList<>();
        mAkunFragments = new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == HOME_POSITION) {
            if (mHomeFragments.isEmpty()) {
                return BASE_FRAGMENTS.get(position);
            }
            return mHomeFragments.get(mHomeFragments.size() - 1);
        } else if (position == FORUM_POSITION) {
            if (mForumFragments.isEmpty()) {
                return BASE_FRAGMENTS.get(position);
            }
            return mForumFragments.get(mForumFragments.size() - 1);
        } else if (position == CHAT_POSITION) {
            if (mChatFragments.isEmpty()) {
                return BASE_FRAGMENTS.get(position);
            }
            return mChatFragments.get(mChatFragments.size() - 1);
        } else {
            if (mAkunFragments.isEmpty()) {
                return BASE_FRAGMENTS.get(position);
            }
            return mAkunFragments.get(mAkunFragments.size() - 1);
        }
    }

    @Override
    public int getCount() {
        return BASE_FRAGMENTS.size();
    }

    @Override
    public long getItemId(int position) {
        if (position == HOME_POSITION && getItem(position).equals(BASE_FRAGMENTS.get(position))) {
            return HOME_POSITION;
        } else if (position == FORUM_POSITION && getItem(position).equals(BASE_FRAGMENTS.get(position))) {
            return FORUM_POSITION;
        } else if (position == CHAT_POSITION && getItem(position).equals(BASE_FRAGMENTS.get(position))) {
            return CHAT_POSITION;
        } else if (position == AKUN_POSITION && getItem(position).equals(BASE_FRAGMENTS.get(position))) {
            return AKUN_POSITION;
        }

        return getItem(position).hashCode();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    public void updateFragment(Fragment fragment, int position) {
        if (!BASE_FRAGMENTS.contains(fragment)) {
            addInnerFragment(fragment, position);
        }
        notifyDataSetChanged();
    }

    public boolean removeFragment(Fragment fragment, int position){
        if (position == HOME_POSITION) {
            if (mHomeFragments.contains(fragment)){
                removeInnerFragment(fragment, mHomeFragments);
                return true;
            }
        } else if (position == FORUM_POSITION) {
            if (mForumFragments.contains(fragment)){
                removeInnerFragment(fragment, mForumFragments);
                return true;
            }
        } else if (position == CHAT_POSITION) {
            if (mChatFragments.contains(fragment)){
                removeInnerFragment(fragment, mChatFragments);
                return true;
            }
        } else if (position == AKUN_POSITION) {
            if (mAkunFragments.contains(fragment)){
                removeInnerFragment(fragment, mAkunFragments);
                return true;
            }
        }

        return false;
    }

    private void removeInnerFragment(Fragment fragment, List<Fragment> tabFragments){
        tabFragments.remove(fragment);
        notifyDataSetChanged();
    }

    private void addInnerFragment(Fragment fragment, int position) {
        if (position == HOME_POSITION) {
            mHomeFragments.add(fragment);
        } else if (position == FORUM_POSITION) {
            mForumFragments.add(fragment);
        } else if (position == CHAT_POSITION) {
            mChatFragments.add(fragment);
        } else {
            mAkunFragments.add(fragment);
        }
    }
}
