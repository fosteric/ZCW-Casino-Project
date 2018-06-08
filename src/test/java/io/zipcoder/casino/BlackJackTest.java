package io.zipcoder.casino;

        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    @Before
    public void setUp()
    {
    }

    @Test
    public void testStartPlayerScore(){
        //Given

        //When
        int expected = 8;
        int actual = Card.getRank(3) + Card.getRank(5);
        //Result
        assertEquals(actual, expected);
    }

    @Test
    public void testStartHouseScore(){
        //Given

        //When
        int expected = 21;
        int actual = Card.getRank(10) + Card.getRank(11);
        //Result
        assertEquals(actual, expected);
    }



}
