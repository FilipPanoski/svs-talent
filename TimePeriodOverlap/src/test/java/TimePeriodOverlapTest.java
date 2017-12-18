import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalTime;


@RunWith(JUnit4.class)
public class TimePeriodOverlapTest {

    private TimePeriodOverlap timePeriodOverlap;

    @Before
    public void setUp() throws Exception{
        timePeriodOverlap = new TimePeriodOverlap(LocalTime.of(5, 30), LocalTime.of(8, 0));
    }

    @Test
    public void testFirstDateEndsBeforeSecondDate() throws Exception {
        boolean result = timePeriodOverlap.overlapsWith(LocalTime.of(9, 30), LocalTime.of(11, 0));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testFirstDateStartsAfterSecondDate() throws Exception {
        boolean result = timePeriodOverlap.overlapsWith(LocalTime.of(1, 30), LocalTime.of(5, 0));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testSecondDateisInsideFirstDate() throws Exception {
        boolean result = timePeriodOverlap.overlapsWith(LocalTime.of(6, 30), LocalTime.of(7, 0));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testFirstDateisInsideFirstDate() throws Exception {
        boolean result = timePeriodOverlap.overlapsWith(LocalTime.of(4, 30), LocalTime.of(9, 0));
        Assert.assertEquals(true, result);
    }
}
