import org.apache.commons.lang3.StringUtils;

public class ImprovedWordCounter {
    int excerciseCounter;

    public static void main(String[] args){
        ImprovedWordCounter iwc = new ImprovedWordCounter();
        System.out.println("Counting the word 'excercise'...");

        iwc.countExcerciseWord(args);
        iwc.printExcerciseWordCounter();
    }

    public void countExcerciseWord(String[] args){
        for (int i=0; i<args.length; i++){
            if (args[i].equalsIgnoreCase("excercise")){
                excerciseCounter++;
            }
        }
    }

    public void printExcerciseWordCounter(){
        System.out.println(excerciseCounter);
    }
}
