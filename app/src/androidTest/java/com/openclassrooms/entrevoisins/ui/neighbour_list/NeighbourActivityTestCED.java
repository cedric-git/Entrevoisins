package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivityTestCEDDDDDD.childAtPosition;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NeighbourActivityTestCED {
    private static int neighbourIndex = 2;
    private NeighbourApiService mService;
    private List<Neighbour> instantTestList;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void linkToAPI() {
        mService = DI.getNewInstanceApiService();
//    }
//
//    public void instantTestList () {
        instantTestList = new ArrayList<>();
        for (Neighbour n : mService.getNeighbours()) {
            if (n.isFavorite())
                instantTestList.add(n);
        }
    }
//    ********************** INSTRIUMENTED TEST ***************************

// 1. Neighbour detail activity page displayed on click of a neighbour/favorite list
    @Test
    public void neighbour_details_activity_page_isDisplayed() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(1, click()));

        onView(withId(R.id.detailGlobalLayout))
                .check(matches(isDisplayed()));
    }

// 2.  Neighbour name is displayed on his/her detail activity page
    @Test
    public void neighbour_details_activity_name_isDisplayed(){
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(neighbourIndex, click()));


        onView(withId(R.id.Neighbour_name_txt))
                .check(matches(withText(mService.getNeighbours().get(neighbourIndex).getName())));
    }

// 3. favorite tab should display favorite neighbour only
    @Test
    public void favoriteTab_displays_just_favorite_neighbours() {

        onView(withContentDescription("Favorites")).perform(click());

        for (int i = 0; i < instantTestList.size(); i++) {
            onView(allOf(withId(R.id.item_list_name),
                    childAtPosition(childAtPosition(withId(R.id.list_neighbours), i), 1),
                    isDisplayed()))
                    .check(matches(withText(instantTestList.get(i).getName())));
        }
    }

}