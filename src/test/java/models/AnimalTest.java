package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void animalInstantiatesCorrectly(){
        Animal firstAnimal= new Animal(23,"Hippo");
        assertEquals(true, firstAnimal instanceof Animal);
    }
}
