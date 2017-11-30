import java.io.*;

public class WordCounter {

    public static void main(String[] args){
        BufferedReader reader = null;
        int counter = 0;
        try {
            FileReader file = new FileReader("File");
            reader = new BufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] word = line.split(" ");
                counter += word.length;
            }
            System.out.println(counter);
        } catch (Exception ex){ex.printStackTrace();}
        finally {
            try {
                reader.close();
            } catch (IOException e) {}
        }

    }
}
