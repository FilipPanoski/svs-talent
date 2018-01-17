import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackImplPushTest {

    private StackImpl stack;

    @Before
    public void setUp(){
        stack = new StackImpl(2);
    }

    @Test
    public void testWhenNotFull() throws Exception {
        stack.push(1);
    }

    @Test
    public void testWhenFull() throws Exception {
        stack.push(1);
        stack.push (2);
        stack.push(3);
    }
}
