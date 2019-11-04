package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI_x_;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI_x_.getNewInstanceApiService();
    }

    @Test
    // Check if DUMMY_NEIGHBOURS is same that list created through API Service
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();   //  <<< neighbour list through API Service
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;    //  <<< neighbours contained in DummyNeighbourGenerator
    assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray())); // <<< check if they are the same
}

    @Test
    // Check if a neighbour deleted do not belong anymore to neighbours' list
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void toggleFavoriteWithSuccess() {
        Neighbour neighbour = service.getNeighbours().get(0); // First neighbour Favorite Status is false
        assertFalse(service.getNeighbours().get(0).getFavoriteStatus());    // Correct, it is false
        service.toggleFavorite(neighbour);                                  // Change Favorite Status
        assertTrue(service.getNeighbours().get(0).getFavoriteStatus());     // Correct, it is true
        service.toggleFavorite(neighbour);                                  // Change Favorite Status
        assertFalse(service.getNeighbours().get(0).getFavoriteStatus());    // Correct, it is false
    }

}
