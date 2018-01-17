import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackImplIsEmptyTest {

    StackImpl stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl(1);
    }

    @Test
    public void testWhenEmpty() throws Exception {
        Assert.assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testWhenNotEmpty() throws Exception {
        stack.push(1);
        Assert.assertEquals(false, stack.isEmpty());
    }
}
