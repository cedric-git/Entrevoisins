package com.openclassrooms.entrevoisins.utils;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class RecyclerViewItemCountAssertion_x_ implements ViewAssertion {
        private final Matcher<Integer> matcher;

        public static RecyclerViewItemCountAssertion_x_ withItemCount(int expectedCount) {
            return withItemCount(Matchers.is(expectedCount));
        }

        public static RecyclerViewItemCountAssertion_x_ withItemCount(Matcher<Integer> matcher) {
            return new RecyclerViewItemCountAssertion_x_(matcher);
        }

        private RecyclerViewItemCountAssertion_x_(Matcher<Integer> matcher) {
            this.matcher = matcher;
        }

        @Override
        public void check(View view, NoMatchingViewException noViewFoundException) {
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }

            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Assert.assertThat(adapter.getItemCount(), matcher);
        }
    }