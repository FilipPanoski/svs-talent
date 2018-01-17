import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackImplPopTest {

    private StackImpl stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl(2);
        stack.push(1);
        stack.push(2);
    }

    @Test
    public void testNotEmptyStack() throws Exception {
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }

    @Test(expected = java.util.EmptyStackException.class)
    public void testEmptyStack() throws Exception {
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
