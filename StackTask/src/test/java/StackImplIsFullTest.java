import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackImplIsFullTest {

    StackImpl stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl(1);
    }

    @Test
    public void testWhenFull() throws Exception {
        stack.push(1);
        Assert.assertEquals(true, stack.isFull());
    }

    @Test
    public void testWhenNotFull() throws Exception {
        Assert.assertEquals(false, stack.isFull());
    }
}
