import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackImplPeekTest {

    private StackImpl stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl(2);
        stack.push(1);
        stack.push(2);
    }

    @Test
    public void testNotEmptyStack() throws Exception {
        Assert.assertEquals(2, stack.peek());
        Assert.assertEquals(2, stack.peek());
    }

    @Test(expected = java.util.EmptyStackException.class)
    public void testEmptyStack() throws Exception {
        makeStackEmpty();
        stack.peek();
    }

    private void makeStackEmpty(){
        stack.pop();
        stack.pop();
    }
}
