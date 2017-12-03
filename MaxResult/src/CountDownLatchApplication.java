import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {

    private static final int NUMBER_OF_OPERATIONS = 10;

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Integer[] calculations = new Integer[NUMBER_OF_OPERATIONS];
        for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
            Future<Integer> complexCalculationFuture = executorService.submit(new ComplexCalculation(i, latch));
            calculations[i] = complexCalculationFuture.get();
        }

        latch.await();
        System.out.println("All complex operations finished.");

        executorService.shutdown();

        System.out.println("Largest result is: " + findMaxResult(calculations));
    }

    private static Integer findMaxResult(Integer[] calculations){
        int tempMax = 0;
        for (int i = 0; i < NUMBER_OF_OPERATIONS; i++){
            if (tempMax < calculations[i]){
                tempMax = calculations[i];
            }
        }
        return tempMax;
    }
}
