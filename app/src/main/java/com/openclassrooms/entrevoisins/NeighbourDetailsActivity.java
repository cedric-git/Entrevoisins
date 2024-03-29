package com.openclassrooms.entrevoisins;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.di.DI_x_;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourDetailsActivity extends AppCompatActivity {

    // UI Components

    @BindView(R.id.toolbar)
    public android.support.v7.widget.Toolbar mToolbar;

    @BindView(R.id.back_btn)
    public ImageButton mToolbarButton;

    @BindView(R.id.neighbour_picture_img)
    public ImageView mNeighbourAvatar;

    @BindView(R.id.Neighbour_name_txt)
    public TextView mToolbarTextView;

    @BindView(R.id.infos_card_name_txt)
    public TextView mInfosCardName;

    @BindView(R.id.website_text)
    public TextView mWebsite_text;

    @BindView(R.id.add_favorite_button_btn)
    public android.support.design.widget.FloatingActionButton mFavFab;

    @BindDrawable(R.drawable.ic_star_border_white_24dp)
    public Drawable mStarWhiteOutlined;

    @BindDrawable(R.drawable.ic_star_yellow_24dp)
    public Drawable mStarYellow;

    private NeighbourApiService mApiService;
    private Neighbour mNeighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_neighbour_details);
        ButterKnife.bind(this);

        mApiService = DI_x_.getNeighbourApiService();
        getNeighbour();         //  <<<<<<<<<<<<<<<
        fillNeighbourInfo();    //  <<<<<<<<<<<<<<<
        FavoriteFAB();          //  <<<<<<<<<<<<<<<
    }

    private void getNeighbour() {
        mNeighbour = getIntent().getParcelableExtra("neighbour");
    }


// ********** Fill UI with detail neighbour info **********

    private void fillNeighbourInfo() {  //  <<<<<<<<<<<<<<< get/set info
        Glide.with(this).load(mNeighbour.getAvatarUrl()).into(mNeighbourAvatar); // neighbour avatar
        mToolbarTextView.setText(mNeighbour.getName()); // neighbour name
        mWebsite_text.setText(mNeighbour.getMail());  // neighbour website
        //  ...
        //  ... etc
        //  ...
        mInfosCardName.setText(mNeighbour.getName());

        mToolbarButton.setOnClickListener(v -> finish());   // <<<<<<<<<<back button
    }

    // ********** Activate Favorite FAB toggling and update favorite value through API **********

    // set FAB color regarding ON/OFF  //  <<<<<<<<<<<<<<<
    private void FavoriteFAB() {
        if (mNeighbour.getFavoriteStatus() == true) {
            mFavFab.setImageDrawable(mStarYellow);
        } else { mFavFab.setImageDrawable(mStarWhiteOutlined); }

    // Record Favorite status
            mFavFab.setOnClickListener(v -> {
                mApiService.toggleFavorite(mNeighbour);
                mNeighbour.setFavoriteStatus(!mNeighbour.getFavoriteStatus());
            FavoriteFAB();
            });
    }
}