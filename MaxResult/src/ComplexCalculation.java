import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ComplexCalculation implements Callable<Integer> {

    private Integer orderNumber;
    private CountDownLatch latch;

    public ComplexCalculation(Integer orderNumber, CountDownLatch latch){
        this.orderNumber = orderNumber + 1;
        this.latch = latch;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println("Complex calculation " + orderNumber + ". started...");

        try {

            Thread.sleep(3000);
            latch.countDown();

        } catch (InterruptedException e) {

        }

        System.out.println("Complex calculation " + orderNumber + ". completed.");

        return new Random().nextInt(10 + 1);

    }

}
