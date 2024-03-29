
package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction_x_;
import org.hamcrest.Matchers;   //  <<<<<<<<<<<<<<<<<<<
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;   //  <<<<<<<<<<<
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion_x_.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;
    private ListNeighbourActivity_x_ mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity_x_> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity_x_.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least one item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() { // return a android.support.test.espresso.AmbiguousViewMatcherException
        // First scroll to the position that needs to be matched and click on it.
        onView(Matchers.allOf(withId(R.id.list_neighbours), isDisplayed()))  //  <<< Matchers.allOf (multiple matches in case of views..., isDisplayed()
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {// return a android.support.test.espresso.AmbiguousViewMatcherException

        // onView(ViewMatchers.withId(R.id.list_neighbours)) <<< no need RecyclerViewActions.
        onView(Matchers.allOf(withId(R.id.list_neighbours), isDisplayed())) //  <<< Matchers.allOf (multiple matches in case of views..., isDisplayed()
                .check(withItemCount(ITEMS_COUNT))

        // We remove the element at position 2  When perform a click on a delete icon

                // .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction_x_()));
                .perform(actionOnItemAtPosition(2, new DeleteViewAction_x_()));  //  <<< no need RecyclerViewActions.

        // onView(ViewMatchers.withId(R.id.list_neighbours))
        onView(Matchers.allOf(withId(R.id.list_neighbours), isDisplayed())) //  <<< Matchers.allOf (multiple matches in case of views..., isDisplayed()
                .check(withItemCount(ITEMS_COUNT-1));

        // Then : the number of element is 11
    }
}