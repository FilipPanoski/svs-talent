import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackImplGrowTest {

    StackImpl stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl(2);
    }

    @Test
    public void testIfStackGrewCorrectly() throws Exception {
        stack.grow(3);
        Assert.assertEquals(5, stack.elements.length);
    }
}
