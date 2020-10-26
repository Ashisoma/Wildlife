package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {

    @Test
    public void animalInstantiatesCorrectly(){
        Endangered firstAnimal = new Endangered("Rhino", 54,"robust");// health should be a constant
        assertEquals(true, firstAnimal instanceof Endangered);
    }

}