package numberprinter;
import static java.lang.Thread.sleep;

public class NumberPrinter {
    
     int number;
     int time;
     int counter = 1;
     boolean interrupt = false;

    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();
        np.setArguments(args);
        np.makeThreads();
    }
    
    public void makeThreads(){
        Thread numberPrinter = new Thread(new Runnable(){
            @Override
            public void run(){
                while (counter <= number && !interrupt){
                    System.out.println(counter);
                    counter++;
                }
            }
        });
        Thread timeCounter = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                sleep(time);
                if (counter != number){
                    interrupt = true;
                }
                } catch (InterruptedException ex){}
            }
        });
        
        numberPrinter.start();
        timeCounter.start();
    }
    
    public void setArguments(String[] args){
        number = Integer.parseInt(args[0]);
        time = Integer.parseInt(args[1]);     
    }
    
}
