package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void animalInstantiatesCorrectly(){
        Animal firstAnimal= new Animal("Zebra");
        assertEquals(true, firstAnimal instanceof Animal);
    }
}
