import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputData {
    public static void getInput() throws FileNotFoundException {
        String input;
        File file = new File("input.txt");
        try{
            Scanner inputScanner = new Scanner(file);
            int i=1;
            while(inputScanner.hasNextLine()){
                System.out.println("Expressin "+i+" RESULT: "+ EvaluateData.evaluateExpression(inputScanner.nextLine()));
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
