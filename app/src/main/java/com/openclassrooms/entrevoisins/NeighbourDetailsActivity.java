package com.openclassrooms.entrevoisins;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourPagerAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourDetailsActivity extends AppCompatActivity {

    // UI Components

    @BindView(R.id.toolbar)
    public android.support.v7.widget.Toolbar mToolbar;

    @BindView(R.id.back_btn)
    public ImageButton mToolbarButton;

    @BindView(R.id.Neighbout_name_txt)
    public TextView mToolbarTextView;

    @BindView(R.id. infos_card_name_txt)
    public TextView mInfosCardName;

    @BindView(R.id.add_favorite_button_btn)
    public android.support.design.widget.FloatingActionButton mFavFab;



    private Neighbour mNeighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);
        ButterKnife.bind(this);
        mNeighbour=getIntent().getParcelableExtra("neighbour");

//        setSupportActionBar(mToolbar);


// **********Fill UI with detail neighbour info **********

//        using API service ???


        mToolbarTextView.setText(mNeighbour.getName());

    }
}
