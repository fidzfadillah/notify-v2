package com.fizha.notifyv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fizha.notifyv2.adapter.MainFragmentPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements FragmentUpdateCallback{
    private static final String TAG = MainActivity.class.getSimpleName();

    private FloatingActionButton addFab, forumFab, voteFab, elearnFab;
    private TextView mForumFab, mVoteFab, mElearnFab;
    private Boolean isAllFabsVisible;

    @BindView(R.id.navbar)
    ChipNavigationBar chipNavigationBar;

    private FragmentManager fragmentManager;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    MainFragmentPagerAdapter mainFragmentPagerAdapter;
    private int mCurrentTabPosition;

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        functionFab();

        fragmentManager = getSupportFragmentManager();
        mainFragmentPagerAdapter = new MainFragmentPagerAdapter(fragmentManager);

        viewPager.setAdapter(mainFragmentPagerAdapter);
        viewPager.setOffscreenPageLimit(4);

        if (savedInstanceState==null){
            chipNavigationBar.setItemSelected(R.id.home, true);
        }

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {

                switch (id){
                    case R.id.home:
                        mCurrentTabPosition = HomeFragment.TAB_POSITION;
                        viewPager.setCurrentItem(mCurrentTabPosition);
                        break;
                    case R.id.forum:
                        mCurrentTabPosition = ForumFragment.TAB_POSITION;
                        viewPager.setCurrentItem(mCurrentTabPosition);
//                        crossfade();
                        break;
                    case R.id.chat:
                        mCurrentTabPosition = ChatFragment.TAB_POSITION;
                        viewPager.setCurrentItem(mCurrentTabPosition);
                        break;
                    case R.id.akun:
                        mCurrentTabPosition = AkunFragment.TAB_POSITION;
                        viewPager.setCurrentItem(mCurrentTabPosition);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!mainFragmentPagerAdapter.removeFragment(mainFragmentPagerAdapter.getItem(mCurrentTabPosition), mCurrentTabPosition)) {
            finish();
        }
    }

    private void initView() {
        viewPager = findViewById(R.id.view_pager);
        chipNavigationBar = findViewById(R.id.navbar);
        mContentView = findViewById(R.id.container);

        addFab = findViewById(R.id.add_fab);
        forumFab = findViewById(R.id.add_forum_fab);
        voteFab = findViewById(R.id.add_vote_fab);
        elearnFab = findViewById(R.id.add_elearn_fab);

        mForumFab = findViewById(R.id.add_forum_action_text);
        mVoteFab = findViewById(R.id.add_vote_action_text);
        mElearnFab = findViewById(R.id.add_elearn_text);
    }

    private void functionFab() {
        forumFab.setVisibility(View.GONE);
        voteFab.setVisibility(View.GONE);
        elearnFab.setVisibility(View.GONE);

        mForumFab.setVisibility(View.GONE);
        mVoteFab.setVisibility(View.GONE);
        mElearnFab.setVisibility(View.GONE);

        isAllFabsVisible = false;

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isAllFabsVisible) {
                    forumFab.show();
                    voteFab.show();
                    elearnFab.show();

                    mForumFab.setVisibility(View.VISIBLE);
                    mVoteFab.setVisibility(View.VISIBLE);
                    mElearnFab.setVisibility(View.VISIBLE);

                    addFab.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));

                    isAllFabsVisible = true;
                } else {
                    forumFab.hide();
                    voteFab.hide();
                    elearnFab.hide();

                    mForumFab.setVisibility(View.GONE);
                    mVoteFab.setVisibility(View.GONE);
                    mElearnFab.setVisibility(View.GONE);

                    isAllFabsVisible = false;
                    addFab.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_add_24));
                }
            }
        });

        forumFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Dalam Pengembangan", Toast.LENGTH_SHORT).show();
            }
        });

        voteFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Dalam Pengembangan", Toast.LENGTH_SHORT).show();
            }
        });

        elearnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Dalam Pengembangan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void addFragment(Fragment fragment, int tabPosition) {
        mainFragmentPagerAdapter.updateFragment(fragment, tabPosition);
    }
}