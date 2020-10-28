package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangersTest {
    @Test
    public void rangersInstantiatesCorrectly() {
        Rangers newRanger = new Rangers("Ken", 7747474, 23);
        assertEquals(true, newRanger instanceof Rangers);
    }
}
