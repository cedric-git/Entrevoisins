package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NeighbourActivityTestCED {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

//    ********************** INSTRIUMENTED TEST ***************************
    @Test
    public void neighbour_details_activity_page_isDisplayed_instrumented_test_I1() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(1, click()));

        onView(withId(R.id.constraintLayout2))
                .check(matches(isDisplayed()));
    }

    @Test
    public void neighbour_details_activity_name_isDisplayed_instrumented_test_I2() {
 }

    @Test
    public void favoriteTab_displays_just_favorite_neighbours_instrumented_test_I4() {
//        or favorite neighbours list contain just favorites - comparer le nombre d' item
    }


    //    ********************** UNIT TEST ***************************
    @Test
    public void check_if_favorite_list_is_created_unit_test_U1() {
    }

    @Test
    public void favoriteFAB_Toggles_neighbour_favorite_property_unit_test_U2() {
//        or add_favorite_with _success
    }


}
