package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test (expected = NullPointerException.class )
    public void testCountNumbers2() {
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    @Test 
    public void testCountNumbers3() {
        mycustomstring.setString("");
        assertEquals (0, mycustomstring.countNumbers());
    }

    //it helps to check the number as one or two id there is space between them
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("Please make sure that 6 1 can be treated or not");
        assertEquals(2, mycustomstring.countNumbers());
    }

    //checks whether 984 is completely different from other two numbers.
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("check if 984 583 76 1");
        assertEquals(4, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("There is nothing-> no numbers.");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    // checks IllegalArgumentException down below
    @Test (expected = IllegalArgumentException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("finding out the testing exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }
    //helps to check NullPointerexception down below
    @Test (expected = NullPointerException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false);
    }

    //checks between two different tests 
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("hello world");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }
    
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("hello world");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }
    
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("random l3t3rz  ar3 not tooo hard too wri!te");
        assertEquals("nm3r 3otoa ort", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("random l3t3rz  ar3 not tooo hard too wri!te");
        assertEquals("aol3 rn ohdow!", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    // checks the whole string here
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("get me the drink");
        assertEquals("get me the drink", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    } 
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("please have a drink");
        assertEquals("please have a drink", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }
    @Test (expected = IllegalArgumentException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("finding out the testing exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, false);
    }
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("niceone");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(12, true));
    }
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("1 2 3 4 5 6 7 8 9 ");
        assertEquals("         ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("1 2 3 4 5 6 7 8 9 ");
        assertEquals("123456789", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("please do a testing randomly  ");
        mycustomstring.convertDigitsToNamesInSubstring(12,9);
    }
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("please do a testing randomly ");
        mycustomstring.convertDigitsToNamesInSubstring(0,9);
    }
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("please do a testing randomly ");
        mycustomstring.convertDigitsToNamesInSubstring(1,mycustomstring.getString().length() + 1);
    }
    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1,2);
    }
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString(" ");
        mycustomstring.convertDigitsToNamesInSubstring(1,1);
    }
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("test92 59 ran89h ");
        mycustomstring.convertDigitsToNamesInSubstring(1, 15);
        assertEquals("testNineTwo FiveNine ranEightNineh ", mycustomstring.getString());
    }
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("test92 59 ran89h ");
        mycustomstring.convertDigitsToNamesInSubstring(1, 15);
        assertEquals("testNineTwo FiveNine ranEightNineh ", mycustomstring.getString());
    }
}