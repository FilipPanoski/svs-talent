import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackImplGetSizeTest {

    StackImpl stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl(2);
        stack.push(1);
    }

    @Test
    public void testIfShowsSizeCorrectly() throws Exception {
        Assert.assertEquals(1, stack.getSize());
    }
}
