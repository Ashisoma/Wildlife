package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangersTest {
    @Test
    public void rangersInstantiatesCorrectly() {
        Rangers newRanger = new Rangers("Ken", 7747474, 23);
        assertEquals(true, newRanger instanceof Rangers);
    }

//    @Test
//    public void newRange_instantiatesNewId() {
//        Rangers newRanger = new Rangers("ken",1234242,123 );
//        Rangers secoondRanger = new Rangers("Kenedy",3234242,23 );
//        assertEquals(true, Rangers);
//
//    }
}
