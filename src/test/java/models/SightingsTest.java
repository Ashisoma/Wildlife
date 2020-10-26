package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {
    @Test
    public void locationInstantiatesCorrectly() {
        Sightings newViewed = new Sightings("Up river");
        assertEquals(true, newViewed instanceof Sightings);
    }
}